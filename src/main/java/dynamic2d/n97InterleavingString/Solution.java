package dynamic2d.n97InterleavingString;

public class Solution {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3.isEmpty()) {
      return s1.isEmpty() && s2.isEmpty();
    }
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }

    boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
          continue;
        }
        if (i == 0) {
          dp[i][j] = s1.charAt(j - 1) == s3.charAt(j - 1) && dp[i][j - 1];
          continue;
        }
        if (j == 0) {
          dp[i][j] = s2.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][j];
          continue;
        }
        dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s2.charAt(i - 1))
            || (dp[i][j - 1] && s3.charAt(i + j - 1) == s1.charAt(j - 1));
      }
    }
    return dp[s2.length()][s1.length()];
  }
}
