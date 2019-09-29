package routing;

public class Tile {

    private char letter;
    private int score;
    private boolean isEmpty;

    public Tile(char letter, int score, boolean isEmpty) {
        this.letter = Character.toUpperCase(letter);
        this.score = score;
        this.isEmpty = isEmpty;
    }

    public char getLetter() {
        return letter;
    }

    public int getScore() {
        return score;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(letter);
        sb.append(score);
        return sb.toString();
    }
}