package dynamic2d.n309BestTimeBuySellStockCooldown;

public class Solution {
 public int maxProfit(int[] prices) {
  int[][] memo =  new int[prices.length][3];
  // 0 - can buy, 1 - can sell, 2 - cooldown

  memo[0][0]=0;
  memo[0][1]= -prices[0];
  memo[0][2]= Integer.MIN_VALUE;
  for(int day =1; day < prices.length;  day++){
   memo[day][0] = Math.max(memo[day-1][0], memo[day-1][2]); //can buy, ie, we have no stock now, and the max profit should be ''last no stock profit'' or ''last rest profit''

   memo[day][1] =  Math.max(memo[day-1][1], memo[day-1][0] - prices[day]); //can sell, ie, we now have stock, and the profit should be ''last stock profit'' or ''last no stock but buy this time''

   memo[day][2]  = memo[day-1][1] + prices[day]; //we should sell then take a rest
  }

  return Math.max(memo[prices.length-1][2],Math.max(memo[prices.length-1][0],memo[prices.length-1][1]));
 }
}
