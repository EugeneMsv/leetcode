package dynamic2d.n518CoinChange2;

public class Solution {

  public int change(int amount, int[] coins) {
    if (amount == 0) {
      return 1;
    }
    int combinations = 0;
    Integer[][] memo = new Integer[coins.length][amount];
    for (int num = 0; num < coins.length; num++) {
      combinations += backtrack(coins, num, amount - coins[num], memo);
    }
    return combinations;
  }

  private int backtrack(int[] coins, int start, int amount, Integer[][] memo) {
    if (amount < 0) {
      return 0;
    }
    if (amount == 0) {
      return 1;
    }
    if (memo[start][amount] != null) {
      return memo[start][amount];
    }
    int result = 0;
    for (int num = start; num < coins.length; num++) {
      result += backtrack(coins, num, amount - coins[num], memo);
    }
    memo[start][amount] = result;
    return result;
  }

}