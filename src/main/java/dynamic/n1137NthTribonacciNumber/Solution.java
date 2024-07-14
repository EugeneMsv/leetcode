package dynamic.n1137NthTribonacciNumber;

class Solution {

  private static int[] memo = new int[38];

  static {
    for (int i = 0; i < memo.length; i++) {
      memo[i] = -1;
    }
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 1;
  }

  public int tribonacci(int n) {
    if (n < 0) {
      return 0;
    }

    if (memo[n] >= 0) {
      return memo[n];
    }

    int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    memo[n] = result;
    return result;
  }
}
