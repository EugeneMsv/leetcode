package hashing.n451SortCharacterByFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

  public String frequencySort(String s) {
    Map<Character, Integer> frequencies = new HashMap<>();

    for (char c : s.toCharArray()) {
      Integer frequency = frequencies.get(c);
      if (frequency == null) {
        frequency = 0;
      }
      frequency++;
      frequencies.put(c, frequency);
    }
    List<Entry<Character, Integer>> entries = new ArrayList<>(frequencies.entrySet());

    Collections.sort(entries,
        Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed());

    StringBuilder result = new StringBuilder();

    for (Map.Entry<Character, Integer> entry : entries) {

      int count = entry.getValue();
      while (count > 0) {
        result.append(entry.getKey());
        count--;
      }
    }

    return result.toString();
  }
}
