package movecalculator;

public class TileHistory {
  private int row;
  private int column;
  private Tile tile;

  public TileHistory(int row, int column, Tile tile) {
    this.row = row;
    this.column = column;
    this.tile = tile;
  }

  public void revert(Board board) {
    board.setTile(row, column, tile);
  }

}
