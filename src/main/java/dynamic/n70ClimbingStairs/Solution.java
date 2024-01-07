package dynamic.n70ClimbingStairs;

public class Solution {

  public int climbStairs(int n) {
    return dp(n, new int[n + 1]);
  }

  private int dp(int n, int[] cache) {
    if (cache[n] != 0) {
      return cache[n];
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int result = dp(n - 1, cache) + dp(n - 2, cache);
    cache[n] = result;
    return result;
  }
}