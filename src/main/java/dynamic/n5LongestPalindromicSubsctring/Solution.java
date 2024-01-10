package dynamic.n5LongestPalindromicSubsctring;

public class Solution {

  public String longestPalindrome(String s) {
    return dp(s, s.length() - 1);
  }

  private String dp(String s, int end) {

    if (end < 0) {
      return "";
    }
    if (end == 0) {
      return String.valueOf(s.charAt(0));
    }

    String prevSubPalidrom = dp(s, end - 1);

    String currentPalindrom = "";
    for (int i = 0; i < end; i++) {
      if (isPalindrom(s, i, end)) {
        currentPalindrom = s.substring(i, end + 1);
        break;
      }
    }

    return currentPalindrom.length() >= prevSubPalidrom.length()
        ? currentPalindrom
        : prevSubPalidrom;
  }

  private boolean isPalindrom(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
