package hashing.n383RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> dict = new HashMap<>();
    for (Character c : magazine.toCharArray()) {
      dict.put(c, dict.getOrDefault(c, 0) + 1);
    }

    for (Character c : ransomNote.toCharArray()) {
      Integer count = dict.get(c);
      if (count == null || count == 0) {
        return false;
      }
      dict.put(c, dict.get(c) - 1);
    }

    return true;
  }
}
