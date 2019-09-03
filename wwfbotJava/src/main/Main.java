package main;

public class Main {
  public static void main(String[] args) {
    Board board = new Board();
    System.out.println(board);;
    Move move = new Move(new Tile[]{new Tile('h'), new Tile('i', true)}, 5, 5, Orientation.HORIZONTAL, 7);
    board.playMove(move);
    System.out.println(board);
    board.playMove(move);
    System.out.println(board);
    if (!board.playMove(move)) {
      System.out.println("Bad...");
    }
    System.out.println(board);
    if (!board.playMove(move)) {
      System.out.println("Good...");
    }
    System.out.println(board);
  }
}
