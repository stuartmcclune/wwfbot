import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static boolean quit = false;

  public static void main(String[] args) throws IOException {
    Board board = new Board();
    System.out.println("New Game Started:");
    System.out.println(board);
    Console con = System.console();
    if (con == null) {
      System.out.println("No console available");
      return;
    }

    while (!quit) {
      String command = con.readLine("Please enter a command:");
      switch (command) {
        case "quit":
          quit = true;
          break;
        case "play":
          String moveStr = con.readLine("Play a move:");
          con.printf("%s\n", moveStr);
          String[] splitMoveStr = moveStr.split(" ");
          for (String s : splitMoveStr) {
            //BUG: This returns a copy.
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
          break;
        case "undo":
          //TODO
          break;
        case "cheat":
          //TODO
          break;
        case "help":
          con.printf("Valid commands: quit, play, undo, cheat, help.");
          break;
        default:
          con.printf("Invalid command. Type \"help\" for all options.\n");


      }



    }
  }

}
