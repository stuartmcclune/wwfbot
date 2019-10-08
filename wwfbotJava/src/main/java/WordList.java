import java.util.*;

public class WordList {
  private static WordList instance;

  private Set<String> words = new HashSet<>();

  public int size() {
    return words.size();
  }

  public boolean contains(String s) {
    return words.contains(s.toLowerCase());
  }

  private WordList() {
    try {
      Scanner scan = new Scanner(this.getClass().getResourceAsStream("/wordlist.txt"));
      while(scan.hasNextLine()) {
        String word = scan.nextLine();
        if (word.length() < 12) {
          words.add(word);
        }
      }
      scan.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

  public static synchronized WordList getInstance() {
    if (instance == null) {
      instance = new WordList();
    }
    return instance;
  }

}
