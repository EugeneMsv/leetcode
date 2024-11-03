package array.n2017GridGame;

class Solution {
 public long gridGame(int[][] grid) {
  long ans = Long.MAX_VALUE, lowerLeft = 0, upperRight = 0;
  for (int cell : grid[0]) {
   upperRight += cell;
  }
  for (int i = 0; i < grid[0].length; ++i) {
   upperRight -= grid[0][i];
   ans = Math.min(ans, Math.max(upperRight, lowerLeft));
   lowerLeft += grid[1][i];
  }
  return ans;
 }
}