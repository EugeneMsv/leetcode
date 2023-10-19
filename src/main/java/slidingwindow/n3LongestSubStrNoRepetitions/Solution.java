package slidingwindow.n3LongestSubStrNoRepetitions;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    Set<Character> dict = new HashSet<>();
    char[] chars = s.toCharArray();
    int begin = 0;
    int end = 1;
    int maxLength = 1;
    dict.add(chars[0]);

    while (end < chars.length) {
      Character endChar = chars[end];
      boolean newlyAdded = dict.add(endChar);
      if (newlyAdded) {
        maxLength = Math.max(maxLength, end - begin + 1);
        end++;
      } else {

        while (begin < end) {
          if (!endChar.equals(chars[begin])) {
            dict.remove(chars[begin]);
            begin++;
          } else {
            begin++;
            break;
          }

        }
        end++;
      }

    }
    return maxLength;
  }
}
