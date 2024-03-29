import java.util.ArrayList;
import java.util.List;

public class Board {
  private boolean isStart = true;

  private Tile[][] board = {
      {
        new Tile(TileType.TL), new Tile(), new Tile(TileType.TW), new Tile(), new Tile(), new Tile(), new Tile(),
          new Tile(), new Tile(TileType.TW), new Tile(), new Tile(TileType.TL)},
      {
        new Tile(), new Tile(TileType.DW), new Tile(), new Tile(), new Tile(), new Tile(TileType.DW), new Tile(),
          new Tile(), new Tile(), new Tile(TileType.DW), new Tile()},
      {
        new Tile(TileType.TW), new Tile(), new Tile(TileType.TL), new Tile(), new Tile(TileType.DL), new Tile(),
          new Tile(TileType.DL), new Tile(), new Tile(TileType.TL), new Tile(), new Tile(TileType.TW)},
      {
        new Tile(), new Tile(), new Tile(), new Tile(TileType.TL), new Tile(), new Tile(), new Tile(),
          new Tile(TileType.TL), new Tile(), new Tile(), new Tile()},
      {
        new Tile(), new Tile(), new Tile(TileType.DL), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(),
          new Tile(TileType.DL), new Tile(), new Tile()},
      {
        new Tile(), new Tile(TileType.DW), new Tile(), new Tile(), new Tile(), new Tile(TileType.START), new Tile(),
          new Tile(), new Tile(), new Tile(TileType.DW), new Tile()},
      {
        new Tile(), new Tile(), new Tile(TileType.DL), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(),
          new Tile(TileType.DL), new Tile(), new Tile()},
      {
        new Tile(), new Tile(), new Tile(), new Tile(TileType.TL), new Tile(), new Tile(), new Tile(),
          new Tile(TileType.TL), new Tile(), new Tile(), new Tile()},
      {
        new Tile(TileType.TW), new Tile(), new Tile(TileType.TL), new Tile(), new Tile(TileType.DL), new Tile(),
          new Tile(TileType.DL), new Tile(), new Tile(TileType.TL), new Tile(), new Tile(TileType.TW)},
      {
        new Tile(), new Tile(TileType.DW), new Tile(), new Tile(), new Tile(), new Tile(TileType.DW), new Tile(),
          new Tile(), new Tile(), new Tile(TileType.DW), new Tile()},
      {
        new Tile(TileType.TL), new Tile(), new Tile(TileType.TW), new Tile(), new Tile(), new Tile(), new Tile(),
          new Tile(), new Tile(TileType.TW), new Tile(), new Tile(TileType.TL)
      },
  };

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(".---.---.---.---.---.---.---.---.---.---.---.\n");
    for (Tile[] row : board) {
      sb.append('|');
      for (Tile tile: row) {
        sb.append(tile);
        sb.append('|');
      }
      sb.append("\n.---.---.---.---.---.---.---.---.---.---.---.\n");
    }
    return sb.toString();
  }

  public Tile getTile(int row, int col) {
    return board[row][col];
  }

  public boolean isClear(int row, int column) {
    Tile tile = board[row][column];
    return tile.getTileType() != TileType.LETTER;
  }

  public boolean isStart() {
    return isStart;
  }

  public boolean playMove(Move move) {
    List<TileHistory> changes = new ArrayList<>();
    Tile[] letterTiles = move.getLetterTiles();
    int row = move.getRow();
    int column = move.getColumn();
    int i;
    int j;
    try {
      switch (move.getOrientation()) {
        case HORIZONTAL:
          i = 0;
          j = column;
          while (i < letterTiles.length) {
            if (isClear(row, j)) {
              changes.add(new TileHistory(row, j, board[row][j]));
              board[row][j] = letterTiles[i];
              i++;
            }
            j++;
          }
          break;
        case VERTICAL:
          i = 0;
          j = row;
          while (i < letterTiles.length) {
            if (isClear(j, column)) {
              changes.add(new TileHistory(j, column, board[j][column]));
              board[j][column] = letterTiles[i];
              i++;
            }
            j++;
          }
      }
      isStart = false;
      return true;
    } catch (IndexOutOfBoundsException e) {
      for (TileHistory change : changes) {
        change.revert(this);
      }
      return false;
    }
  }

  public void setTile(int row, int column, Tile tile) {
    board[row][column] = tile;
  }

  public int dist(int row, int col, Orientation ori) {
    if (!isClear(row, col)) {
      return 0;
    }
    if (ori == Orientation.VERTICAL) {
      for (int i = 0; i < 11 - row; i++) {
        if (isTouching(row + i, col)) {
          return i + 1;
        }
      }
    } else {
      for (int i = 0; i < 11 - col; i++) {
        if (isTouching(row, col + i)) {
          return i + 1;
        }
      }
    }
    return -1;
  }

  private boolean isTouching(int row, int col) {
    try {
      if (!isClear(row - 1, col)) {
        return true;
      }
    } catch (IndexOutOfBoundsException e) {
      //Intentionally blank.
    }
    try {
      if (!isClear(row + 1, col)) {
        return true;
      }
    } catch (IndexOutOfBoundsException e) {
      //Intentionally blank.
    }
    try {
      if (!isClear(row, col - 1)) {
        return true;
      }
    } catch (IndexOutOfBoundsException e) {
      //Intentionally blank.
    }
    try {
      if (!isClear(row, col + 1)) {
        return true;
      }
    } catch (IndexOutOfBoundsException e) {
      //Intentionally blank.
    }
    return false;

  }

}
