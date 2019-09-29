package routing;

public class Tile {

    private char letter;
    private int score;

    public Tile(char letter, int score) {
        this.letter = letter;
        this.score = score;
    }

    public char getLetter() {
        return letter;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(letter);
        sb.append(score);
        return sb.toString();
    }
}