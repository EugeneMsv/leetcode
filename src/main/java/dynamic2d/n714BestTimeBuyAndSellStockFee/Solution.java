package dynamic2d.n714BestTimeBuyAndSellStockFee;

class Solution {

  // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/1600084/dp-state-machine-top-down-to-bottom-up-with-space-optimization-approaches/?envType=study-plan-v2&envId=leetcode-75
  static int[] prices;
  static int fee;
  static Integer[][] memo;

  public int maxProfit(int[] pricesIn, int feeIn) {
    prices = pricesIn;
    fee = feeIn;
    // [][0] -  no stock, [][1] have stock
    memo = new Integer[prices.length][2];

    // stockPresence == 1 because there is no point to buy last day and we want to go to branch where we sell or skip last day
    return dfs(prices.length - 1, 1);
  }

  // stockPresence = 0 - > not stock,  1 -> has stock
  private int dfs(int day, int stockPresence) {
    if (day == 0) {
      memo[0][stockPresence] = stockPresence == 0
          ? -prices[0] - fee
          : 0;
      return memo[0][stockPresence];
    }

    if (memo[day][stockPresence] != null) {
      return memo[day][stockPresence];
    }

    int hasStockResult = Integer.MIN_VALUE;
    int noStockResult = Integer.MIN_VALUE;

    if (stockPresence == 0) {
      // max of skip the day or buy and pay the fee
      noStockResult = Math.max(dfs(day - 1, 0), dfs(day - 1, 1) - prices[day] - fee);
    } else {
      // max of skip the day or sell
      hasStockResult = Math.max(dfs(day - 1, 1), dfs(day - 1, 0) + prices[day]);
    }

    memo[day][stockPresence] = Math.max(noStockResult, hasStockResult);
    return memo[day][stockPresence];
  }
}
