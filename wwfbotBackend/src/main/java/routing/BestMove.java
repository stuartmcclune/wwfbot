package routing;

import java.util.List;

public class BestMove {

    private final List<Tile> letters;
    private final int row;
    private final int column;
    private final String orientation;
    private final int score;

    public BestMove(List<Tile> letters, int row, int column, String orientation, int score) {
        this.letters = letters;
        this.row = row;
        this.column = column;
        this.orientation = orientation;
        this.score = score;
    }

    public List<Tile> getLetters() {
        return letters;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getScore() {
        return score;
    }

}