import java.util.*;
import java.util.stream.Stream;

import utils.Pair;
import org.paukov.combinatorics3.Generator;

public class Main {

  private static boolean quit = false;
  private static Board board;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    board = new Board();
    System.out.println("New Game Started:");
    System.out.println(board);
    while (!quit) {
      System.out.println("Please enter a command:");
      String command = sc.nextLine();
      switch (command) {
        case "quit":
          quit = true;
          break;
        case "play":
          play();
          break;
        case "undo":
          //TODO
          break;
        case "cheat":
          cheat();
          break;
        case "show":
          System.out.println(board);
          break;
        case "help":
          System.out.println("Valid commands: quit, play, undo, cheat, show, help.");
          break;
        default:
          System.out.println("Invalid command. Type \"help\" for all options.");

      }
    }
  }

  private static void cheat() {
    // Read rack from console.
    //TODO: validity check. As below.
    Scanner sc = new Scanner(System.in);
    System.out.println("Type letters in rack (if blank, type \'?\'):");
    String rackString = sc.nextLine();
    // Convert String to array of Tiles, setting letter to Character.MIN_VALUE if blank.
    long millis = System.currentTimeMillis();
    int rackSize = rackString.length();
    Tile[] rackTiles = new Tile[rackSize];
    for (int i = 0; i < rackSize; i++) {
      if (rackString.charAt(i) == '?') {
        rackTiles[i] = new Tile(Character.MIN_VALUE, true);
      } else {
        rackTiles[i] = new Tile(rackString.charAt(i), false);
      }
    }

    Pair<Move, Integer> bestMoveAndScore = new Pair<>(null, -1);

    if (board.isStart()) {
      //First move.
      for (int k = 2; k < rackSize + 1; k++) {
        Pair<Move, Integer> thisBestMoveAndScore = Generator.combination(rackTiles)
            .simple(k)
            .stream()
            .parallel()
            .flatMap(combination -> Generator.permutation(combination)
                .simple()
                .stream().parallel())
            .flatMap(p -> substituteBlanks(p))
            .map(p -> new Move(p, 5, p.size() == 7 ? 4 : 5, Orientation.HORIZONTAL))
            .map(m -> new Pair<Move, Integer>(m, m.getScore(board)))
            .reduce(new Pair<Move, Integer>(null, -1), (currentBest, elem) -> elem.getValue() >= currentBest.getValue() ? elem : currentBest);
        bestMoveAndScore = thisBestMoveAndScore.getValue() >= bestMoveAndScore.getValue() ? thisBestMoveAndScore : bestMoveAndScore;
      }
    } else {
      //Not first move.
      //Get all permutations to avoid recomputation.
      Map<Integer,List<List<Tile>>> perms = new HashMap<>();
      for (int k = 1; k < rackSize + 1; k++) {
        List<List<Tile>> kPerms = new ArrayList<>();

        Generator.combination(rackTiles)
            .simple(k)
            .stream()
            .flatMap(combination -> Generator.permutation(combination)
              .simple()
              .stream())
            .flatMap(Main::substituteBlanks)
            .forEach(kPerms::add);
        perms.put(k, kPerms);
      }

      //Iterate over every possible move.
      for (int i = 0; i < 11; i++) {
        for (int j = 0; j < 11; j++) {
          int hDist = board.dist(i, j, Orientation.HORIZONTAL);
          int vDist = board.dist(i, j, Orientation.VERTICAL);
          if (hDist > 0) {
            for (int k = hDist; k < rackSize + 1; k++) {
              int finalI = i;
              int finalJ = j;
              Pair<Move, Integer> thisBestMoveAndScore = perms.get(k)
                  .stream()
                  .parallel()
                  .map(p -> new Move(p, finalI, finalJ, Orientation.HORIZONTAL))
                  .map(m -> new Pair<Move, Integer>(m, m.getScore(board)))
                  .reduce(new Pair<Move, Integer>(null, -1), (currentBest, elem) -> elem.getValue() >= currentBest.getValue() ? elem : currentBest);
              bestMoveAndScore = thisBestMoveAndScore.getValue() >= bestMoveAndScore.getValue() ? thisBestMoveAndScore : bestMoveAndScore;
            }
          }

          if (vDist > 0) {
            for (int k = vDist; k < rackSize + 1; k++) {
              int finalI = i;
              int finalJ = j;
              Pair<Move, Integer> thisBestMoveAndScore = perms.get(k)
                  .stream()
                  .parallel()
                  .map(p -> new Move(p, finalI, finalJ, Orientation.VERTICAL))
                  .map(m -> new Pair<Move, Integer>(m, m.getScore(board)))
                  .reduce(new Pair<Move, Integer>(null, -1), (currentBest, elem) -> elem.getValue() >= currentBest.getValue() ? elem : currentBest);
              bestMoveAndScore = thisBestMoveAndScore.getValue() >= bestMoveAndScore.getValue() ? thisBestMoveAndScore : bestMoveAndScore;
            }
          }
        }
      }
    }

    Move bestMove = bestMoveAndScore.getKey();
    int bestScore = bestMoveAndScore.getValue();

    if (bestScore == -1) {
      System.out.println("No possible move.");
      return;
    }

    StringBuilder wordSB = new StringBuilder();
    for (Tile t : bestMove.getLetterTiles()) {
      if (t.isBlank()) {
        wordSB.append('?');
      }
      wordSB.append(t.getLetter());
    }
    System.out.println("BEST MOVE");
    System.out.println("Letters: " + wordSB);
    System.out.println("Row: " + bestMove.getRow());
    System.out.println("Column: " + bestMove.getColumn());
    System.out.println("Orientation: " + bestMove.getOrientation());
    System.out.println("Score: " + bestScore);
    System.out.println("------------------------------");
    System.out.println("Time taken to compute: " + ((System.currentTimeMillis() - millis)/1000) + "s");

  }

  private static Stream<List<Tile>> substituteBlanks(List<Tile> p) {
    //Assume no blanks. Will be overwritten if blanks found.
    Stream<List<Tile>> res = Stream.of(p);
    //Iterate through all letters.
    for (int i = 0; i < p.size(); i++) {
      //Check for blanks.
      if (p.get(i).getLetter() == Character.MIN_VALUE) {
        //If blank found, substitute it for all a-z, and look again for next blank.
        res = substituteBlankAtIndex(p, i)
            .flatMap(s -> substituteBlanks(s));
      }
    }

    return res;
  }

  private static Stream<List<Tile>> substituteBlankAtIndex(List<Tile> p, int i) {
    List<List<Tile>> subs = new ArrayList<>();
    for (int j = 0; j < 26; j++) {
      //Shallow copy.
      List<Tile> newP = new ArrayList<>(p);
      newP.set(i, new Tile((char) (j + ((int) 'a')), true));
      subs.add(newP);
    }

    return subs.stream();
  }

  private static void play() {
    // Read letters from console.
    //TODO: validity check on string - either check contents or catch exception when tile constructed.
    Scanner sc = new Scanner(System.in);
    System.out.println("Type letters played (if blank, prepend with \'?\'):");
    String letters = sc.nextLine();
    // Convert String to array of Tiles.
    List<Tile> letterTilesList = new ArrayList<>();
    boolean isBlank = false;
    for (int i = 0; i < letters.length(); i++) {
      if (letters.charAt(i) == '?') {
        isBlank = true;
      } else {
        letterTilesList.add(new Tile(letters.charAt(i), isBlank));
        isBlank = false;
      }
    }
    // Array not directly made since blanks mean length of string isn't equal to number of tiles.
    Tile[] letterTiles = new Tile[letterTilesList.size()];
    letterTilesList.toArray(letterTiles);

    //TODO: Extract to method.

    // Read row from console.
    int row = -1;
    boolean validRow = false;
    while (!validRow) {
      sc = new Scanner(System.in);
      System.out.println("Type row of first letter (starting from 0 at top):");
      try {
        row = sc.nextInt();
        validRow = row <= 10 && row >= 0;
      } catch (Exception e) {
        validRow = false;
      }
      if (!validRow) {
        System.out.println("Invalid row: Must be an integer between 0 and 10 inclusive.");
      }
    }

    // Read row from console.
    int col = -1;
    boolean validCol = false;
    while (!validCol) {
      sc = new Scanner(System.in);
      System.out.println("Type column of first letter (starting from 0 on left):");
      try {
        col = sc.nextInt();
        validCol = col <= 10 && col >= 0;
      } catch (Exception e) {
        validCol = false;
      }
      if (!validCol) {
        System.out.println("Invalid column: Must be an integer between 0 and 10 inclusive.");
      }
    }

    // Read orientation from console.
    boolean validOri = false;
    Orientation ori = null;
    while (!validOri) {
      System.out.println("Type orientation of letters to play (h for horizontal, v for vertical):");
      sc = new Scanner(System.in);
      String oriString = sc.nextLine();
      switch (oriString) {
        case "h":
          ori = Orientation.HORIZONTAL;
          validOri = true;
          break;
        case "v":
          ori = Orientation.VERTICAL;
          validOri = true;
          break;
        default:
          System.out.println("Invalid orientation: Must be \'h\' or \'v\'.");
          validOri = false;
      }
    }

    // Play move and print board.
    Move move = new Move(letterTiles, row, col, ori);
    if (board.playMove(move)) {
      System.out.println(board);
    } else {
      System.out.println("Invalid move: Please make sure your move can be played on the board.");
      play();
    }


  }

}
