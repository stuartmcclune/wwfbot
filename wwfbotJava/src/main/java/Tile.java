public class Tile {
  private TileType tileType = TileType.LETTER;
  private boolean isBlank = false;
  private char letter;
  private int score;

  public Tile(char letter, boolean isBlank) {
    this.letter = Character.toLowerCase(letter);
    this.isBlank = isBlank;
    if (!isBlank) {
      this.score = Utils.getScore(letter);
    }
  }

  public Tile(char letter) {
    this.letter = Character.toLowerCase(letter);
    this.score = Utils.getScore(letter);
  }

  public Tile() {
    tileType = TileType.EMPTY;
  }

  public Tile(TileType tileType) {
    this.tileType = tileType;
  }

  public Tile(Tile other) {
    tileType = other.tileType;
    isBlank = other.isBlank;
    letter = other.letter;
    score = other.score;
  }

  public boolean isBlank() {
    return isBlank;
  }

  public char getLetter() {
    return letter;
  }

  public TileType getTileType() {
    return tileType;
  }

  @Override
  public String toString() {
    switch (tileType) {
      case EMPTY: return "   ";
      case DW: return "DW ";
      case TW: return "TW ";
      case DL: return "DL ";
      case TL: return "TL ";
      case START: return " + ";
      case LETTER: return letter + " " + (isBlank ? "0" : score);
    }
    return "ERR";
  }

}
