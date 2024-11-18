package bitmanipulation.n861ScoreAfterFlippingMatrix;

class Solution {
 public int matrixScore(int[][] grid) {
  for(int row = 0; row < grid.length; row++){
   if(grid[row][0] ==0){
    flipRow(grid, row);
   }
  }


  for(int column = 1; column < grid[0].length; column++){
   int zeros = 0;
   int ones = 0;
   for(int row =0; row < grid.length; row++){
    if(grid[row][column] == 0){
     zeros++;
    }else{
     ones++;
    }
   }
   if(zeros > ones) {
    flipColumn(grid, column);
   }
  }

  int sum = 0;
  for(int i = 0; i < grid.length;  i++){
   StringBuilder sb =  new StringBuilder();
   for(int j = 0; j < grid[i].length; j++){
    sb.append(grid[i][j]);
   }
   sum+=Integer.parseInt(sb.toString(),2);

  }

  return sum;

 }


 private void flipRow(int[][] grid, int row){
  for(int j = 0; j < grid[row].length; j++){
   grid[row][j] = grid[row][j] ==0 ? 1 : 0;
  }
 }

 private void flipColumn(int[][] grid, int column){
  for(int i = 0; i < grid.length; i++){
   grid[i][column] = grid[i][column] == 0 ? 1 : 0;
  }
 }
}
