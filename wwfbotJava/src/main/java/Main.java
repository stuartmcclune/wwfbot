import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static boolean quit = false;
  private static Board board;

  public static void main(String[] args) throws IOException {
    //Board board = new Board();
    board = new Board();
    System.out.println("New Game Started:");
    System.out.println(board);
    Console con = System.console();
    if (con == null) {
      System.out.println("No console available");
      return;
    }

    while (!quit) {
      String command = con.readLine("Please enter a command:\n");
      switch (command) {
        case "quit":
          quit = true;
          break;
        case "play":
          play(con);
          break;
        case "undo":
          //TODO
          break;
        case "cheat":
          //TODO
          break;
        case "help":
          con.printf("Valid commands: quit, play, undo, cheat, help.\n");
          break;
        default:
          con.printf("Invalid command. Type \"help\" for all options.\n");


      }



    }
  }

  private static void play(Console con) {
    // Read letters from console.
    //TODO: validity check on string - either check contents or catch exception when tile constructed.
    String letters = con.readLine("Type letters played (if blank, prepend with \'?\'):\n");
    // Convert String to array of Tiles.
    List<Tile> letterTilesList = new ArrayList<>();
    boolean isBlank = false;
    for (int i = 0; i < letters.length(); i++) {
      if (letters.charAt(i) == '?') {
        isBlank = true;
      } else {
        letterTilesList.add(new Tile(letters.charAt(i), isBlank));
        isBlank = false;
      }
    }
    // Array not directly made since blanks mean length of string isn't equal to number of tiles.
    Tile[] letterTiles = new Tile[letterTilesList.size()];
    letterTilesList.toArray(letterTiles);

    //TODO: Extract to method.

    // Read row from console.
    int row = -1;
    boolean validRow = false;
    while (!validRow) {
      Scanner sc = new Scanner(con.reader());
      con.printf("Type row of first letter (starting from 0 at top):\n");
      try {
        row = sc.nextInt();
        validRow = row <= 10 && row >= 0;
      } catch (Exception e) {
        validRow = false;
      }
      if (!validRow) {
        con.printf("Invalid row: Must be an integer between 0 and 10 inclusive.\n");
      }
    }

    // Read row from console.
    int col = -1;
    boolean validCol = false;
    while (!validCol) {
      Scanner sc = new Scanner(con.reader());
      con.printf("Type column of first letter (starting from 0 on left):\n");
      try {
        col = sc.nextInt();
        validCol = col <= 10 && col >= 0;
      } catch (Exception e) {
        validCol = false;
      }
      if (!validCol) {
        con.printf("Invalid column: Must be an integer between 0 and 10 inclusive.\n");
      }
    }

    // Read orientation from console.
    boolean validOri = false;
    Orientation ori = null;
    while (!validOri) {
      String oriString = con.readLine("Type orientation of letters to play (h for horizontal, v for vertical):\n");
      switch (oriString) {
        case "h":
          ori = Orientation.HORIZONTAL;
          validOri = true;
          break;
        case "v":
          ori = Orientation.VERTICAL;
          validOri = true;
          break;
        default:
          con.printf("Invalid orientation: Must be \'h\' or \'v\'.\n");
          validOri = false;
      }
    }

    // Play move and print board.
    Move move = new Move(letterTiles, row, col, ori, 0);
    if (board.playMove(move)) {
      System.out.println(board);
    } else {
      con.printf("Invalid move: Please make sure your move can be played on the board.\n");
      play(con);
    }


  }

}
