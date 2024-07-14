package dynamic2d.n121BestTimeBuyAndSellStock;

class Solution {

  public int maxProfit(int[] prices) {
    int[] dp = new int[prices.length];
    dp[0] = 0;
    int max = 0;
    for (int day = 1; day < prices.length; day++) {
      int profit = prices[day] - prices[day - 1];
      dp[day] = Math.max(dp[day - 1] + profit, profit);
      max = Math.max(max, dp[day]);
    }

    return max;
  }
}
