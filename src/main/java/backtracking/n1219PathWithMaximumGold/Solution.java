package backtracking.n1219PathWithMaximumGold;

class Solution {
 private static int MAX =  0;

 public int getMaximumGold(int[][] grid) {
  MAX =0;
  for(int i =0; i < grid.length; i++){
   for(int j =0; j < grid[i].length; j++){
    backtrack(grid, i,j, 0);
   }
  }
  return MAX;
 }


 void backtrack(int[][] grid, int x, int y, int sum){
  if(x >= grid.length || x <0
      || y >=grid[x].length || y <0){
   return;
  }
  int val = grid[x][y];
  if( val <= 0){
   return;
  }
  int updatedSum = sum+val;
  MAX=Math.max(MAX, updatedSum);

  grid[x][y] = -grid[x][y];
  backtrack(grid, x+1, y, updatedSum);
  backtrack(grid, x-1, y, updatedSum);
  backtrack(grid, x, y+1, updatedSum);
  backtrack(grid, x, y-1, updatedSum);
  grid[x][y] = -grid[x][y];

 }



}
