package movecalculator;

import java.util.*;
import java.util.stream.Stream;

import movecalculator.utils.Pair;
import org.paukov.combinatorics3.Generator;

import routing.BestMove;
import routing.BestMoveRequestBody;

public class MoveCalculator {

  private Board board;
  private Tile[] rack;

  public MoveCalculator(BestMoveRequestBody requestBody) {
    List<routing.Tile> requestBoard = requestBody.getBoard();
    List<routing.Tile> requestRack = requestBody.getRack();

    this.board = new Board();
    for (int i = 0; i < requestBoard.size(); i++) {
      int row = i / 11;
      int column = i % 11;
      routing.Tile reqTile = requestBoard.get(i);
      if (reqTile.getLetter() == ' ') {
        continue;
      }
      Tile tile = new Tile(reqTile.getLetter(), reqTile.getScore() == 0);

      board.setTile(row, column, tile);
      board.setIsStart(false);
    }

    int rackSize = 0;
    for (routing.Tile reqTile : requestRack) {
      if (reqTile.getLetter() != ' ') {
        rackSize++;
      }
    }
    rack = new Tile[rackSize];
    int i = 0;
    for (routing.Tile reqTile : requestRack) {
      if (reqTile.getLetter() == ' ') {
        continue;
      }
      boolean isBlank = reqTile.getScore() == 0;
      Tile tile = new Tile(isBlank ? Character.MIN_VALUE : reqTile.getLetter(), isBlank);
      rack[i] = tile;
      i++;
    }

  }

  public BestMove getBestMove() {

    int rackSize = rack.length;

    Pair<Move, Integer> bestMoveAndScore = new Pair<>(null, -1);

    if (board.isStart()) {
      //First move.
      for (int k = 2; k < rackSize + 1; k++) {
        Pair<Move, Integer> thisBestMoveAndScore = Generator.combination(rack)
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

        Generator.combination(rack)
            .simple(k)
            .stream()
            .flatMap(combination -> Generator.permutation(combination)
              .simple()
              .stream())
            .flatMap(MoveCalculator::substituteBlanks)
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
      return new BestMove(null, -1, -1, null, -1);
    }

    List<routing.Tile> responseTiles = new ArrayList<>();
    for (Tile t : bestMove.getLetterTiles()) {
      responseTiles.add(new routing.Tile(t.getLetter(), t.getScore(), true));
    }

    return new BestMove(responseTiles, bestMove.getRow(), bestMove.getColumn(), bestMove.getOrientation() == Orientation.HORIZONTAL ? "h" : "v", bestScore);

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

}
