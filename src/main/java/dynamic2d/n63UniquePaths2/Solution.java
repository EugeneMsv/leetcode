package dynamic2d.n63UniquePaths2;

class Solution {
 public int uniquePathsWithObstacles(int[][] grid) {
  Integer[][] memo = new Integer[grid.length][grid[0].length];
  memo[0][0] = grid[0][0] == 0 ? 1: 0;
  return dp(memo, grid, grid.length-1, grid[0].length-1);
 }

 private int dp(Integer[][] memo, int[][] grid, int x, int y){
  if(x < 0 || x>= grid.length
      || y <0 || y >= grid[x].length){
   return 0;
  }

  Integer ways = memo[x][y];

  if(ways !=null){
   return ways;
  }

  if(grid[x][y] == 1){
   memo[x][y] = 0;
   return 0;
  }

  ways = dp(memo, grid, x, y-1) + dp(memo, grid, x-1, y);

  memo[x][y]=ways;
  return ways;

 }
}