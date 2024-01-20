package dynamic2d.n1143LongestCommonSubSequence;

public class Solution {

  public int longestCommonSubsequence(String n, String m) {

    int[][] memo = new int[n.length()][m.length()];

    int matches = 0;
    for (int j = 0; j < m.length(); j++) {
      if (n.charAt(0) == m.charAt(j)) {
        matches = 1;
      }
      memo[0][j] = matches;
    }
    matches = 0;
    for (int i = 0; i < n.length(); i++) {
      if (n.charAt(i) == m.charAt(0)) {
        matches = 1;
      }
      memo[i][0] = matches;
    }

    for (int i = 1; i < n.length(); i++) {
      for (int j = 1; j < m.length(); j++) {

        if (n.charAt(i) == m.charAt(j)) {
          memo[i][j] = memo[i - 1][j - 1] + 1;
        } else {
          memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
        }

      }
    }
    return memo[n.length() - 1][m.length() - 1];
  }
}