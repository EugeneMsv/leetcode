package dynamic.n746MinCostClimbingStairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int minCostClimbingStairs(int[] cost) {
    Map<Integer, Integer> memo = new HashMap<>();
    memo.put(0, 0);
    memo.put(1, 0);
    return dp(cost, memo, cost.length);
  }

  private int dp(int[] cost, Map<Integer, Integer> memo, int step) {
    if (memo.get(step) != null) {
      return memo.get(step);
    }

    int result = Math.min(dp(cost, memo, step - 1) + cost[step - 1],
        dp(cost, memo, step - 2) + cost[step - 2]);
    memo.put(step, result);
    return result;
  }
}
