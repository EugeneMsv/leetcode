package hashing.n1657DetermineIfTwoStringsAreClose;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    Map<Character, Integer> freq1 = new HashMap<>();
    Map<Character, Integer> freq2 = new HashMap<>();

    for (int i = 0; i < word1.length(); i++) {
      char c1 = word1.charAt(i);
      char c2 = word2.charAt(i);
      freq1.put(c1, freq1.getOrDefault(c1, 0) + 1);
      freq2.put(c2, freq2.getOrDefault(c2, 0) + 1);
    }

    if (freq1.size() != freq2.size() || !freq1.keySet().equals(freq2.keySet())) {
      return false;
    }

    Map<Integer, Integer> freqRev1 = new HashMap<>();
    Map<Integer, Integer> freqRev2 = new HashMap<>();

    for (Integer freq : freq1.values()) {
      freqRev1.put(freq, freqRev1.getOrDefault(freq, 0) + 1);
    }
    for (Integer freq : freq2.values()) {
      freqRev2.put(freq, freqRev2.getOrDefault(freq, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry1 : freqRev1.entrySet()) {
      Integer chars = freqRev2.get(entry1.getKey());
      if (chars == null || chars != entry1.getValue()) {
        return false;
      }
    }

    return true;
  }
}
