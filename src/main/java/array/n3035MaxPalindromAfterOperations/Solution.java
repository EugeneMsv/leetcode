package array.n3035MaxPalindromAfterOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxPalindromesAfterOperations(String[] words) {
    Map<Character, Integer> freq = new HashMap<>();
    for (String word : words) {
      for (char c : word.toCharArray()) {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
      }
    }

    Arrays.sort(words, Comparator.comparing(String::length));

    int totalPairs = 0;
    for (Integer value : freq.values()) {

      totalPairs += value / 2;

    }

    int palindromesCount = 0;
    for (String word : words) {
      if (word.isEmpty() || word.length() == 1) {
        palindromesCount++;
        continue;
      }

      if (word.length() / 2 <= totalPairs) {
        totalPairs -= word.length() / 2;
        palindromesCount++;
      } else {
        break;
      }
    }

    return palindromesCount;
  }
}
