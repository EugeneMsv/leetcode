package slidingwindow.n122BestTimeBuyAndSellStock2;

public class Solution {

  public int maxProfit(int[] prices) {

    if (prices.length == 1) {
      return 0;
    }
    int buyIdx = 0;
    int sellIdx = -1;

    int i = 1;
    int overallProfit = 0;
    int localProfit = 0;
    while (i < prices.length) {
      int curPrice = prices[i];

      if (sellIdx != -1) {
        // When next sell candidate is smaller than previous, we should sell prev and start new buy cycle
        if (curPrice <= prices[sellIdx]) {
          overallProfit += localProfit;
          localProfit = 0;
          buyIdx = i;
          sellIdx = -1;
        } else {
          // when next sell candidate is bigger, than change the prev sell candidate to the new one
          sellIdx = i;
          localProfit = Math.max(localProfit, curPrice - prices[buyIdx]);
        }
        continue;
      }

      // When next buy is smaller and we don't yest sold
      if (sellIdx == -1) {
        if (prices[buyIdx] < curPrice) {
          // found first local place to sell
          sellIdx = i;
          localProfit = Math.max(localProfit, curPrice - prices[buyIdx]);
        } else {
          buyIdx = i;
        }
      }
      i++;
    }
    if (sellIdx != -1) {
      overallProfit += localProfit;
    }
    return overallProfit;
  }
}
