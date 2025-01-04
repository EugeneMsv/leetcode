package graph.n463IslandPerimeter;

class Solution {
 public int islandPerimeter(int[][] grid) {
  int sum = 0;
  for(int i = 0; i < grid.length; i++){
   for(int j = 0; j < grid[i].length; j++){
    sum+=perimeter(grid, i,j);
   }
  }

  return sum;
 }


 private int perimeter(int[][] grid, int x, int y){
  if(grid[x][y] ==0){
   return 0;
  }

  int perimeter = 4;
  perimeter-=neigbourCount(grid, x-1, y);
  perimeter-=neigbourCount(grid, x+1, y);
  perimeter-=neigbourCount(grid, x, y-1);
  perimeter-=neigbourCount(grid, x, y+1);

  return perimeter;
 }

 private int neigbourCount(int[][] grid, int x, int y){
  if(x < 0 || x>= grid.length
      || y <0 || y >= grid[x].length){
   return 0;
  }

  return grid[x][y];
 }
}
