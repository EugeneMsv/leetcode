package hashing.n290WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> map = new HashMap<>();
    Map<String, Character> reversedMap = new HashMap<>();
    int wIdx = 0;
    String[] words = s.split(" ");

    for (Character p : pattern.toCharArray()) {
      if (wIdx >= words.length) {
        // System.out.println(wIdx);
        return false;
      }
      String word = map.get(p);
      Character c = reversedMap.get(words[wIdx]);
      if (word == null && c == null) {
        map.put(p, words[wIdx]);
        reversedMap.put(words[wIdx], p);
      } else {
        if (!words[wIdx].equals(word) || !p.equals(c)) {
          return false;
        }
      }
      wIdx++;
    }

    return wIdx == words.length;

  }
}
