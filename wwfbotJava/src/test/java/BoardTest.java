import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

  @Test
  public void boardCorrectOnInit() {
    Board board = new Board();
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   | + |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));
  }

  @Test
  public void canPlaySimpleHorizontalMove() {
    Board board = new Board();
    Move move = new Move(new Tile[]{new Tile('h'), new Tile('i')}, 0, 0, Orientation.HORIZONTAL);
    assertThat(board.playMove(move), is(true));
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|h 3|i 1|TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   | + |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));

  }

  @Test
  public void canPlaySimpleVerticalMove() {
    Board board = new Board();
    Move move = new Move(new Tile[]{new Tile('h'), new Tile('i')}, 0, 0, Orientation.VERTICAL);
    assertThat(board.playMove(move), is(true));
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|h 3|   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|i 1|DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   | + |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));

  }

  @Test
  public void canPlayBlanks() {
    Board board = new Board();
    Move move = new Move(new Tile[]{new Tile('h', true), new Tile('i')}, 0, 0, Orientation.HORIZONTAL);
    assertThat(board.playMove(move), is(true));
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|h 0|i 1|TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   | + |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));

  }

  @Test
  public void moveCannotStartOutOfBounds() {
    Board board = new Board();
    Move move = new Move(new Tile[]{new Tile('h'), new Tile('i')}, 0, -1, Orientation.HORIZONTAL);
    assertThat(board.playMove(move), is(false));
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   | + |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));
  }

  @Test
  public void moveCannotGoOutOfBounds() {
    Board board = new Board();
    Move move = new Move(new Tile[]{new Tile('h'), new Tile('i')}, 10, 10, Orientation.HORIZONTAL);
    assertThat(board.playMove(move), is(false));
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   | + |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |   |   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));
  }

  @Test
  public void canPlayCrossingMoves() {
    Board board = new Board();
    Move move = new Move(new Tile[]{new Tile('h'), new Tile('e'), new Tile('y')}, 5, 4, Orientation.HORIZONTAL);
    assertThat(board.playMove(move), is(true));
    move = new Move(new Tile[]{new Tile('h'), new Tile('y')}, 4,5, Orientation.VERTICAL);
    assertThat(board.playMove(move), is(true));
    assertThat(board.toString(), is(
        ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |h 3|   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |h 3|e 1|y 3|   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |DL |   |   |y 3|   |   |DL |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |   |   |TL |   |   |   |TL |   |   |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TW |   |TL |   |DL |   |DL |   |TL |   |TW |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|   |DW |   |   |   |DW |   |   |   |DW |   |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n" +
            "|TL |   |TW |   |   |   |   |   |TW |   |TL |\n" +
            ".---.---.---.---.---.---.---.---.---.---.---.\n"));

  }
}
