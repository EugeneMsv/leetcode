package dynamic.n647PalindromicSubstrings;

public class Solution {

  public int countSubstrings(String s) {
    return dp(s, s.length() - 1);
  }

  private int dp(String s, int end) {
    if (end < 0) {
      return 0;
    }

    int subCount = dp(s, end - 1);

    int count = 0;
    for (int i = 0; i <= end; i++) {
      if (isPalindrom(s, i, end)) {
        count++;
      }
    }

    return count + subCount;

  }

  private boolean isPalindrom(String s, int start, int end) {
    while (start <= end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
