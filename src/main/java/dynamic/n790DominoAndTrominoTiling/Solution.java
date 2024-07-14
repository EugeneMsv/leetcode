package dynamic.n790DominoAndTrominoTiling;

class Solution {

  public int numTilings(int n) {

    long[] dp = new long[n > 3 ? n + 1 : 4];
    dp[0] = 0L;
    dp[1] = 1L;
    dp[2] = 2L;
    dp[3] = 5L;
    for (int i = 4; i <= n; i++) {
      dp[i] = (2 * dp[i - 1] + dp[i - 3]) % 1_000_000_007;
    }

    return (int) dp[n];
  }
}