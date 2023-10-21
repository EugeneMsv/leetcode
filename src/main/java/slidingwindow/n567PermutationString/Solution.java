package slidingwindow.n567PermutationString;

public class Solution {

  public boolean checkInclusion(String s1, String s2) {
    int[] s1Dict = new int[26];
    for (char letter : s1.toCharArray()) {
      s1Dict[letter - 'a']++;
    }
    int[] windowDict = new int[26];
    int windowSize = s1.length();
    char[] chars = s2.toCharArray();

    int begin = 0;
    int end = 0;
    while (end < chars.length) {
      int letter = chars[end];
      if (end - begin + 1 < windowSize) {
        // one letter before it gets equals to window size
        windowDict[letter - 'a']++;
        end++;
        continue;
      }
      windowDict[letter - 'a']++;

      if (isEqual(s1Dict, windowDict)) {
        return true;
      }
      int toRemoveLetter = chars[begin];
      windowDict[toRemoveLetter - 'a']--;
      begin++;
      end++;
    }
    return false;

  }

  private boolean isEqual(int[] dict1, int[] dict2) {
    for (int i = 0; i < dict1.length; i++) {
      if (dict1[i] != dict2[i]) {
        return false;
      }
    }
    return true;
  }
}