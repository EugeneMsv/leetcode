package slidingwindow.n76MinimumWindowSubstring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

  public String minWindow(String s, String t) {
    if (t.isEmpty()) {
      return "";
    }

    if (s.contains(t)) {
      return t;
    }

    Map<Character, Boolean> idealCovered = new HashMap<>();
    Map<Character, Integer> dict = new HashMap<>();

    for (char c : t.toCharArray()) {
      Integer freq = dict.getOrDefault(c, 0);
      dict.put(c, freq + 1);
      idealCovered.put(c, true);
    }

    int left = -1;
    int right = -1;
    Map<Character, Boolean> windowCovered = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    List<Character> minCandidate = new LinkedList<>();
    boolean moveRight = true;
    List<Character> latestMin = null;
    while (right < s.length() - 1) {

      if (!moveRight) {
        //Move left pointer
        if (latestMin == null || latestMin.size() > minCandidate.size()) {
          latestMin = List.copyOf(minCandidate);
        }

        Character c = minCandidate.get(0);
        Integer windowFreq = window.get(c);
        Integer newFreq = windowFreq - 1;
        Integer idealFreq = dict.get(c);

        if (idealFreq != null && newFreq < idealFreq) {
          moveRight = true;
          continue;
        }
        left++;
        minCandidate.remove(0);
        window.put(c, newFreq);

      } else {
        // Move right pointer
        right++;

        Character c = s.charAt(right);
        Integer windowFreq = window.getOrDefault(c, 0);
        Integer newFreq = windowFreq + 1;
        Integer idealFreq = dict.get(c);
        if (idealFreq != null && newFreq >= idealFreq) {
          windowCovered.put(c, true);
          moveRight = !windowCovered.equals(idealCovered);
        }

        window.put(c, newFreq);
        minCandidate.add(c);

      }

    }

    // When we reached the end but there is some space to move for left
    while (right - left + 1 > t.length()) {

      left++;

      Character c = minCandidate.get(0);
      Integer windowFreq = window.get(c);
      Integer newFreq = windowFreq - 1;
      Integer idealFreq = dict.get(c);

      if (idealFreq != null && newFreq < idealFreq) {
        break;
      }
      minCandidate.remove(0);
      window.put(c, newFreq);
    }

    if (latestMin != null && latestMin.size() < minCandidate.size()) {
      minCandidate = latestMin;
    }

    return windowCovered.equals(idealCovered)
        ? minCandidate.stream()
        .map(String::valueOf)
        .collect(Collectors.joining())
        : "";
  }
}
