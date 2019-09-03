package main;

import static java.util.Map.entry;

import java.util.Map;

public class Utils {
  private static final Map<Character, Integer> letterScores = Map.ofEntries(entry('a', 1), entry('b', 4),
      entry('c', 4), entry('d', 2), entry('e', 1), entry('f', 4), entry('g', 3),
      entry('h', 3), entry('i', 1), entry('j', 10), entry('k', 5), entry('l', 2),
      entry('m', 4), entry('n', 2), entry('o', 1), entry('p', 4), entry('q', 10),
      entry('r', 1), entry('s', 1), entry('t', 1), entry('u', 2), entry('v', 5),
      entry('w', 4), entry('x', 8), entry('y', 3), entry('z', 10));

  private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
      79, 83, 89, 97, 101};

  public static int getScore(char letter) {
    return letterScores.get(Character.toLowerCase(letter));
  }

  public static int getPrime(int index) {
    return primes[index];
  }

  public static int getPrime(char letter) {
    int index = (int) Character.toLowerCase(letter) - (int)'a';
    return primes[index];
  }

  public static int getAnagramKey(String word) {
    int key = 1;
    for (char c : word.toCharArray()) {
      key *= getPrime(c);
    }
    return key;
  }
}
