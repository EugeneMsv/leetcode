package graph.n1254NumberOfClosedIslands;

class Solution {
 final static int[] xDirections = new int[]{1,0,0,-1};
 final static int[] yDirections = new int[]{0,1,-1,0};

 public int closedIsland(int[][] grid) {

  boolean[][] visited =  new boolean[grid.length][grid[0].length];
  int closed = 0;
  for(int i =0; i < grid.length; i++){
   for(int j = 0; j < grid[i].length; j++){
    if(grid[i][j] == 0 && !visited[i][j]){
     closed += dfsClosed(grid, i, j, visited) ? 1 : 0;
    }
   }
  }

  return closed;
 }


 private boolean dfsClosed(int[][] grid, int i, int j, boolean[][] visited){
  visited[i][j] = true;

  boolean result = true;
  for(int k =0; k < 4 ; k++){
   int x = xDirections[k];
   int y = yDirections[k];

   if(!isOutBorder(grid, i+x, j+y) && grid[i+x][j+y] ==0 && !visited[i+x][j+y]){
    result &= dfsClosed(grid, i+x, j+y, visited);
   }
  }
  return isBorder(grid, i, j) ? false : result;
 }

 private boolean isBorder(int[][] grid, int i, int j){
  return i ==0 || i == grid.length-1 || j ==0 || j ==grid[i].length-1;
 }

 private boolean isOutBorder(int[][] grid, int i, int j){
  return i < 0 || i >= grid.length || j < 0 || j >=grid[i].length;
 }
}
