package math.n1672RichestCustomerWealth;

class Solution {
 public int maximumWealth(int[][] customers) {
  int max = Integer.MIN_VALUE;

  for(int[] banks : customers){
   int cur = 0;
   for(int bank : banks){
    cur+=bank;
   }
   max = Math.max(cur, max);
  }

  return max;
 }
}
