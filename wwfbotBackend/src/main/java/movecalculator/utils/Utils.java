package movecalculator.utils;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
  private static final Map<Character, Integer> letterScores = Stream.of(new Object[][] {
      {'a', 1}, {'b', 4}, {'c', 4}, {'d', 2}, {'e', 1}, {'f', 4}, {'g', 3}, {'h', 3}, {'i', 1}, {'j', 10}, {'k', 5},
      {'l', 2}, {'m', 4}, {'n', 2}, {'o', 1}, {'p', 4}, {'q', 10}, {'r', 1}, {'s', 1}, {'t', 1}, {'u', 2}, {'v', 5},
      {'w', 4}, {'x', 8}, {'y', 3}, {'z', 10},
  }).collect(Collectors.collectingAndThen(
      Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]),
      Collections::<Character, Integer> unmodifiableMap
  ));

  public static int getScore(char letter) {
    return letterScores.get(Character.toLowerCase(letter));
  }

}
