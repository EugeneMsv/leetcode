package dynamic.n322CoinChange;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (coins == null || coins.length == 0 || amount < 0) {
      return -1;
    }

    int result = coinChangeHelper(coins, amount, new HashMap<>());
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  /**
   * @return Integer.MAX_VALUE if no combination is possible
   */
  private int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer> memo) {
    if (amount == 0) {
      return 0;
    }
    if (memo.containsKey(amount)) {
      return memo.get(amount);
    }

    int minCount = Integer.MAX_VALUE;
    for (int c : coins) {
      if (amount >= c) {
        int count = coinChangeHelper(coins, amount - c, memo);
        if (count != Integer.MAX_VALUE) {
          minCount = Math.min(minCount, count + 1);
        }
      }
    }

    memo.put(amount, minCount);
    return minCount;
  }
}
