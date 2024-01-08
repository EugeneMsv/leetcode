package dynamic.n198HouseRobber;

import java.util.Map;

public class Solution {

  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int[] memo = new int[nums.length];
    int profit = 0;
    memo[0] = nums[0];
    memo[1] = Math.max(nums[1], nums[0]);
    for (int houses = 2; houses < nums.length; houses++) {
      profit = Math.max(memo[houses - 1], memo[houses - 2] + nums[houses]);
      memo[houses] = profit;
    }

    return Math.max(memo[nums.length - 1], memo[nums.length - 2]);
  }

  private int dpRecursive(int[] nums, Map<Integer, Integer> memo, int houses) {
    if (houses < 0) {
      return 0;
    }
    if (memo.get(houses) != null) {
      return memo.get(houses);
    }
    int profit = Math.max(dpRecursive(nums, memo, houses - 1),
        dpRecursive(nums, memo, houses - 2) + nums[houses]);
    memo.put(houses, profit);
    return profit;

  }
}