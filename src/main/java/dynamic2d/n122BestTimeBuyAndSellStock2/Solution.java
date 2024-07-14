package dynamic2d.n122BestTimeBuyAndSellStock2;

class Solution {

  static int[] prices;
  static int max;
  static Integer[][] memo;

  public int maxProfit(int[] pricesIn) {
    prices = pricesIn;
    max = 0;
    // [day][0] no stock, [day][1] - has stock
    memo = new Integer[pricesIn.length][2];

    return dfs(prices.length - 1, 1);
  }

  private int dfs(int day, int stockPresence) {
    if (memo[day][stockPresence] != null) {
      return memo[day][stockPresence];
    }
    if (day == 0) {
      memo[day][stockPresence] = stockPresence == 0
          ? -prices[day]
          : 0;
      return memo[day][stockPresence];
    }

    int noStockResult = Integer.MIN_VALUE, hasStockResult = Integer.MIN_VALUE;
    if (stockPresence == 0) {
      noStockResult = Math.max(dfs(day - 1, 0), dfs(day - 1, 1) - prices[day]);
    } else {
      hasStockResult = Math.max(dfs(day - 1, 1), dfs(day - 1, 0) + prices[day]);
    }

    int result = Math.max(noStockResult, hasStockResult);
    memo[day][stockPresence] = result;
    return result;
  }

}
