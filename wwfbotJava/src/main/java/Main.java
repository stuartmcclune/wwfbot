import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    int rackSize = rackString.length();
    Tile[] rackTiles = new Tile[rackSize];
    for (int i = 0; i < rackSize; i++) {
      if (rackString.charAt(i) == '?') {
        rackTiles[i] = new Tile(Character.MIN_VALUE, true);
      } else {
        rackTiles[i] = new Tile(rackString.charAt(i), false);
      }
    }

    List<Move> moves = new ArrayList<>();

    if (board.isStart()) {
      //First move.
      for (int i = 1; i < rackSize + 1; i++) {
        Generator.combination(rackTiles)
            .simple(i)
            .stream()
            .forEach(combination -> Generator.permutation(combination)
            .simple()
            .forEach(p -> moves.add(new Move(p, 5, p.size() == 7 ? 4 : 5, Orientation.HORIZONTAL))));
      }
    } else {
      //Not first move.
      for (int i = 0; i < 11; i++) {
        for (int j = 0; j < 11; j++) {
          int hDist = board.dist(i, j, Orientation.HORIZONTAL);
          int vDist = board.dist(i, j, Orientation.VERTICAL);
          if (hDist > 0) {
            for (int k = hDist; k < rackSize + 1; k++) {
              int finalI = i;
              int finalJ = j;
              Generator.combination(rackTiles)
                  .simple(k)
                  .stream()
                  .forEach(combination -> Generator.permutation(combination)
                      .simple()
                      .forEach(p -> moves.add(new Move(p, finalI, finalJ, Orientation.HORIZONTAL))));
            }
          }
          if (vDist > 0) {
            for (int k = vDist; k < rackSize + 1; k++) {
              //TODO: avoid repeat computation.
              int finalI = i;
              int finalJ = j;
              Generator.combination(rackTiles)
                  .simple(k)
                  .stream()
                  .forEach(combination -> Generator.permutation(combination)
                      .simple()
                      .forEach(p -> moves.add(new Move(p, finalI, finalJ, Orientation.VERTICAL))));
            }
          }
        }
      }
    }
    System.out.println("Considering " + moves.size() + " possible moves.");

    int bestScore = -1;
    Move bestMove = null;
    for (Move m : moves) {
      int score = m.getScore(board);
      if (score >= bestScore) {
        bestScore = score;
        bestMove = m;
      }
    }
    if (bestScore == -1) {
      System.out.println("No possible move.");
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (Tile t : bestMove.getLetterTiles()) {
      if (t.isBlank()) {
        sb.append('?');
      }
      sb.append(t.getLetter());
    }
    System.out.println("BEST MOVE");
    System.out.println("Letters: " + sb);
    System.out.println("Row: " + bestMove.getRow());
    System.out.println("Column: " + bestMove.getColumn());
    System.out.println("Orientation: " + bestMove.getOrientation());
    System.out.println("Score: " + bestScore);

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
