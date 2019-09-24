import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Move {
  private Tile[] letterTiles;
  private int row;
  private int column;
  private Orientation orientation;
  private int rackLength;

  //TODO: Does rackLength have to be in move? Maybe a scoredMove object?
  public Move(Tile[] letterTiles, int row, int column, Orientation orientation, int rackLength) {
    this.letterTiles = letterTiles;
    this.row = row;
    this.column = column;
    this.orientation = orientation;
    this.rackLength = rackLength;
  }

  public Move(List<Tile> letterTiles, int row, int column, Orientation orientation, int rackLength) {
    this.letterTiles = new Tile[letterTiles.size()];
    letterTiles.toArray(this.letterTiles);
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


  public int getScore(Board board) {
    Deque<Character> word = new ArrayDeque<>();
    int n = letterTiles.length;
    int wordScore = 0;
    int wordMultiplier = 1;
    int score = n == 7 ? 35 : 0;
    if (orientation == Orientation.HORIZONTAL) {
      //Constructing one horizontal word.
      //New letters.
      for (int i = 0; i < n; i++) {
        int letterMultiplier = 1;
        word.addLast(letterTiles[i].getLetter());
        //TODO: Check for out of bounds.
        //TODO: Change to allow for crossing existing words.
        switch (board.getTile(row, column + i).getTileType()) {
          case TL:
            letterMultiplier = 3;
            break;
          case DL:
            letterMultiplier = 2;
            break;
          case DW:
            wordMultiplier *= 2;
            break;
          case TW:
            wordMultiplier *= 3;
            break;
          default:
            break;
        }
        wordScore += letterTiles[i].getScore() * letterMultiplier;
      }
      //Existing letters after.
      int c = column + n;
      while(c < 11 && !board.isClear(row, c)) {
        Tile tile = board.getTile(row, c);
        word.addLast(tile.getLetter());
        wordScore += tile.getScore();
        c++;
      }
      //Existing letters before.
      c = column - 1;
      while(c >= 0 && !board.isClear(row, c)) {
        Tile tile = board.getTile(row, c);
        word.addFirst(tile.getLetter());
        wordScore += tile.getScore();
        c--;
      }
      //Calculate score.
      wordScore *= wordMultiplier;
      score += wordScore;
      //Convert Deque<Character> to String.
      Character[] wordCharacterArray = new Character[word.size()];
      word.toArray(wordCharacterArray);
      char[] wordCharArray = new char[word.size()];
      for (int i = 0; i < word.size(); i++) {
        wordCharArray[i] = wordCharacterArray[i];
      }
      String wordStr = new String(wordCharArray);
      //Check if word is valid.
      if (wordStr.length() > 1 && !WordList.getInstance().containsMap(wordStr)) {
        return -1;
      }

      //Construct up to n vertical words.
      for (int i = 0; i < n; i++) {
        //New letter.
        word = new ArrayDeque<>();
        wordScore = 0;
        wordMultiplier = 1;
        int letterMultiplier = 1;
        word.addLast(letterTiles[i].getLetter());
        switch (board.getTile(row, column + i).getTileType()) {
          case TL:
            letterMultiplier = 3;
            break;
          case DL:
            letterMultiplier = 2;
            break;
          case DW:
            wordMultiplier *= 2;
            break;
          case TW:
            wordMultiplier *= 3;
            break;
          default:
            break;
        }
        wordScore += letterTiles[i].getScore() * letterMultiplier;

        //Existing letters below.
        int r = row + 1;
        while(r < 11 && !board.isClear(r, column + i)) {
          Tile tile = board.getTile(r, column + i);
          word.addLast(tile.getLetter());
          wordScore += tile.getScore();
          r++;
        }
        //Existing letters above.
        r = row - 1;
        while(r >= 0 && !board.isClear(r, column + i)) {
          Tile tile = board.getTile(r, column + i);
          word.addFirst(tile.getLetter());
          wordScore += tile.getScore();
          r--;
        }

        //Calculate score.
        wordScore *= wordMultiplier;
        score += wordScore;
        //Convert Deque<Character> to String.
        wordCharacterArray = new Character[word.size()];
        word.toArray(wordCharacterArray);
        wordCharArray = new char[word.size()];
        for (int j = 0; j < word.size(); j++) {
          wordCharArray[j] = wordCharacterArray[j];
        }
        wordStr = new String(wordCharArray);
        //Check if word is valid.
        if (wordStr.length() > 1 && !WordList.getInstance().containsMap(wordStr)) {
          return -1;
        }
      }
    } else {
      //Vertical move.
      //Constructing one vertical word.
      //New letters.
      for (int i = 0; i < n; i++) {
        int letterMultiplier = 1;
        word.addLast(letterTiles[i].getLetter());
        switch (board.getTile(row + i, column).getTileType()) {
          case TL:
            letterMultiplier = 3;
            break;
          case DL:
            letterMultiplier = 2;
            break;
          case DW:
            wordMultiplier *= 2;
            break;
          case TW:
            wordMultiplier *= 3;
            break;
          default:
            break;
        }
        wordScore += letterTiles[i].getScore() * letterMultiplier;
      }
      //Existing letters after.
      int r = row + n;
      while(r < 11 && !board.isClear(r, column)) {
        Tile tile = board.getTile(r, column);
        word.addLast(tile.getLetter());
        wordScore += tile.getScore();
        r++;
      }
      //Existing letters before.
      r = row - 1;
      while(r >= 0 && !board.isClear(r, column)) {
        Tile tile = board.getTile(r, column);
        word.addFirst(tile.getLetter());
        wordScore += tile.getScore();
        r--;
      }
      //Calculate score.
      wordScore *= wordMultiplier;
      score += wordScore;
      //Convert Deque<Character> to String.
      Character[] wordCharacterArray = new Character[word.size()];
      word.toArray(wordCharacterArray);
      char[] wordCharArray = new char[word.size()];
      for (int i = 0; i < word.size(); i++) {
        wordCharArray[i] = wordCharacterArray[i];
      }
      String wordStr = new String(wordCharArray);
      //Check if word is valid.
      if (wordStr.length() > 1 && !WordList.getInstance().containsMap(wordStr)) {
        return -1;
      }

      //Construct up to n horizontal words.
      for (int i = 0; i < n; i++) {
        //New letter.
        word = new ArrayDeque<>();
        wordScore = 0;
        wordMultiplier = 1;
        int letterMultiplier = 1;
        word.addLast(letterTiles[i].getLetter());
        switch (board.getTile(row + i, column).getTileType()) {
          case TL:
            letterMultiplier = 3;
            break;
          case DL:
            letterMultiplier = 2;
            break;
          case DW:
            wordMultiplier *= 2;
            break;
          case TW:
            wordMultiplier *= 3;
            break;
          default:
            break;
        }
        wordScore += letterTiles[i].getScore() * letterMultiplier;

        //Existing letters after.
        int c = column + 1;
        while(c < 11 && !board.isClear(row + i, c)) {
          Tile tile = board.getTile(row + i, c);
          word.addLast(tile.getLetter());
          wordScore += tile.getScore();
          c++;
        }
        //Existing letters before.
        c = column - 1;
        while(c >= 0 && !board.isClear(row + i, c)) {
          Tile tile = board.getTile(row + i, c);
          word.addFirst(tile.getLetter());
          wordScore += tile.getScore();
          c--;
        }

        //Calculate score.
        wordScore *= wordMultiplier;
        score += wordScore;
        //Convert Deque<Character> to String.
        wordCharacterArray = new Character[word.size()];
        word.toArray(wordCharacterArray);
        wordCharArray = new char[word.size()];
        for (int j = 0; j < word.size(); j++) {
          wordCharArray[j] = wordCharacterArray[j];
        }
        wordStr = new String(wordCharArray);
        //Check if word is valid.
        if (wordStr.length() > 1 && !WordList.getInstance().containsMap(wordStr)) {
          return -1;
        }
      }
    }
    return score;
  }
}
