import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    Board board = new Board();
    System.out.println("New Game Started:");
    System.out.println(board);
    Console con = System.console();
    if (con == null) {
      System.out.println("No console available");
      return;
    }

    while (true) {
      String moveStr = con.readLine("Play a move:");
      con.printf("%s\n", moveStr);
      String[] splitMoveStr = moveStr.split(",");
      for (String s : splitMoveStr) {
        s.trim();
      }
      for (String m : splitMoveStr) {
        System.out.println(m);
      }
      List<Tile> letterTilesList = new ArrayList<>();
      boolean isBlank = false;
      for (int i = 0; i < splitMoveStr[0].length(); i++) {
        if (splitMoveStr[0].charAt(i) == '?') {
          isBlank = true;
        } else {
          letterTilesList.add(new Tile(splitMoveStr[0].charAt(i), isBlank));
          isBlank = false;
        }
      }

      Tile[] letterTiles = new Tile[letterTilesList.size()];
      //TODO: Check valid input.
      Move move = new Move(letterTilesList.toArray(letterTiles), Integer.parseInt(splitMoveStr[1]), Integer.parseInt(splitMoveStr[2]),
          splitMoveStr[3].toLowerCase().equals("h") ? Orientation.HORIZONTAL : Orientation.VERTICAL, 0);

      board.playMove(move);
      System.out.println(board);
    }
  }

}
