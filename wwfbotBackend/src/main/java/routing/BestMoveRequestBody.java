package routing;

import java.util.List;

public class BestMoveRequestBody {
    private List<Tile> rack;
    private List<Tile> board;

    public BestMoveRequestBody(List<Tile> rack, List<Tile> board) {
        this.rack = rack;
        this.board = board;
    }

    public List<Tile> getRack() {
        return rack;
    }

    public List<Tile> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rack: ");
        for (Tile t : rack) {
            sb.append(t.toString());
        }
        sb.append(", Board: ");
        for (Tile t : board) {
            sb.append(t.toString());
        }
        return sb.toString();
    }
}