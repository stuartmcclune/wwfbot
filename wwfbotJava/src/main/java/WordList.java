import javax.lang.model.type.ArrayType;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordList {
  private static WordList instance;

  private Map<Integer, List<String>> anagramMap = new HashMap<>();
  private List<String> words = Collections.emptyList();

  public int size() {
    return words.size();
  }

  public boolean containsList(String s) {
    return words.contains(s.toLowerCase());
  }

  public boolean containsMap(String s) {
    int key = Utils.getAnagramKey(s);
    if (!anagramMap.containsKey(key)) {
      return false;
    }
    return anagramMap.get(key).contains(s.toLowerCase());
  }

  private WordList() {
    try {
      words = Files.readAllLines(Paths.get("wordlist.txt"), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String word : words) {
      int key = Utils.getAnagramKey(word);
      if (anagramMap.containsKey(key)) {
        anagramMap.get(key).add(word);
      } else {
        List<String> l = new ArrayList<>();
        l.add(word);
        anagramMap.put(key, l);
      }
    }
  }

  public static synchronized WordList getInstance() {
    if (instance == null) {
      instance = new WordList();
    }
    return instance;
  }

}
