public class Move {
  private Tile[] letterTiles;
  private int row;
  private int column;
  private Orientation orientation;
  private int rackLength;

  public Move(Tile[] letterTiles, int row, int column, Orientation orientation, int rackLength) {
    this.letterTiles = letterTiles;
    this.row = row;
    this.column = column;
    this.orientation = orientation;
    this.rackLength = rackLength;
  }

  public Tile[] getLetterTiles() {
    return letterTiles;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public int getRackLength() {
    return rackLength;
  }

}
