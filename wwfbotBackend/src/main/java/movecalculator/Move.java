package movecalculator;

import java.util.List;

public class Move {
  private Tile[] letterTiles;
  private int row;
  private int column;
  private Orientation orientation;

  public Move(Tile[] letterTiles, int row, int column, Orientation orientation) {
    this.letterTiles = letterTiles;
    this.row = row;
    this.column = column;
    this.orientation = orientation;
  }

  public Move(List<Tile> letterTiles, int row, int column, Orientation orientation) {
    this.letterTiles = new Tile[letterTiles.size()];
    letterTiles.toArray(this.letterTiles);
    this.row = row;
    this.column = column;
    this.orientation = orientation;
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

  public int findAndScoreWord(Board board, int row, int column, Orientation orientation, int numberNewTiles, int lettersOffset) {
    int wordScore = 0;
    int wordMultiplier = 1;
    StringBuilder word = new StringBuilder();

    //Find start of word.
    int c = column - 1;
    int r = row - 1;
    if (orientation == Orientation.HORIZONTAL) {
      //Horizontal.
      //Decrement c until -1 or clear tile found.
      while (c >= 0 && !board.isClear(row, c)) {
        c--;
      }
    } else {
      //Vertical.
      //Decrement r until -1 or clear tile found.
      while (r >= 0 && !board.isClear(r, column)) {
        r--;
      }
    }
    //Increment c and r to index of first letter of word.
    c++;
    r++;

    //Iterate through whole word.
    int lettersIndex = 0;
    while (c < 11 && r < 11 && (lettersIndex < numberNewTiles || !board.isClear(r, c))) {
      Tile tile = board.getTile(r, c);
      switch (tile.getTileType()) {
        case LETTER:
          word.append(tile.getLetter());
          wordScore += tile.getScore();
          break;
        case TW:
          word.append(letterTiles[lettersIndex + lettersOffset].getLetter());
          wordScore += letterTiles[lettersIndex + lettersOffset].getScore();
          lettersIndex++;
          wordMultiplier *= 3;
          break;
        case DW:
          word.append(letterTiles[lettersIndex + lettersOffset].getLetter());
          wordScore += letterTiles[lettersIndex + lettersOffset].getScore();
          lettersIndex++;
          wordMultiplier *= 2;
          break;
        case DL:
          word.append(letterTiles[lettersIndex + lettersOffset].getLetter());
          wordScore += letterTiles[lettersIndex + lettersOffset].getScore() * 2;
          lettersIndex++;
          break;
        case TL:
          word.append(letterTiles[lettersIndex + lettersOffset].getLetter());
          wordScore += letterTiles[lettersIndex + lettersOffset].getScore() * 3;
          lettersIndex++;
          break;
        default:
          word.append(letterTiles[lettersIndex + lettersOffset].getLetter());
          wordScore += letterTiles[lettersIndex + lettersOffset].getScore();
          lettersIndex++;
          break;
      }
      if (orientation == Orientation.HORIZONTAL) {
        c++;
      } else {
        r++;
      }
    }

    //Invalid move - can't fit all letters on board.
    if (lettersIndex < numberNewTiles) {
      return -1;
    }
    //One letter words don't count.
    if (word.length() == 1) {
      return 0;
    }
    //Check if word is valid.
    if (WordList.getInstance().containsMap(word.toString())) {
      //Calculate score.
      return wordScore * wordMultiplier;
    } else {
      //Invalid word.
      return -1;
    }
  }


  public int getScore(Board board) {
    int n = letterTiles.length;
    int wordScore;
    int score = n == 7 ? 35 : 0;
    if (orientation == Orientation.HORIZONTAL) {
      //One horizontal word formed.
      wordScore = findAndScoreWord(board, row, column, Orientation.HORIZONTAL, n, 0);
      if (wordScore == -1) {
        return -1;
      }
      score += wordScore;

      //Up to n vertical words formed.
      for (int i = 0; i < n; i++) {
        wordScore = findAndScoreWord(board, row, column + i, Orientation.VERTICAL, 1, i);
        if (wordScore == -1) {
          return -1;
        }
        score += wordScore;
      }

    } else {
      //One vertical word formed.
      wordScore = findAndScoreWord(board, row, column, Orientation.VERTICAL, n, 0);
      if (wordScore == -1) {
        return -1;
      }
      score += wordScore;

      //Up to n horizontal words formed.
      for (int i = 0; i < n; i++) {
        wordScore = findAndScoreWord(board, row + i, column, Orientation.HORIZONTAL, 1, i);
        if (wordScore == -1) {
          return -1;
        }
        score += wordScore;
      }

    }
    return score;
  }

}
