package graph.n1091ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

 static final int[] xOffset = new int[]{-1,-1,-1,0,1,1,1,0};
 static final int[] yOffset = new int[]{-1,0,1,1,1,0,-1,-1};

 public int shortestPathBinaryMatrix(int[][] grid) {
  if(grid.length ==1){
   return grid[0][0] == 0 ? 1 : -1;
  }
  if(grid[0][0] !=0){
   return -1;
  }

  Queue<int[]> q = new LinkedList<>();

  q.offer(new int[]{0,0});
  markAsVisited(grid, 0,0);

  int finalX = grid.length -1;
  int finalY = grid[finalX].length -1;

  int length = 1;
  while(!q.isEmpty()){
   int size = q.size();

   for(int i = 0; i < size; i++){
    int[] node = q.poll();
    int x = node[0];
    int y = node[1];
    if(x == finalX && y == finalY){
     return length;
    }

    for(int offset = 0; offset < xOffset.length; offset++){
     int nextX = x + xOffset[offset];
     int nextY = y + yOffset[offset];
     if(canVisit(grid, nextX, nextY)){
      q.offer(new int[]{nextX, nextY});
      markAsVisited(grid,nextX, nextY);
     }
    }
   }
   length++;
  }

  return -1;
 }



 private void markAsVisited(int[][] grid, int x, int y){
  grid[x][y] =-1;
 }

 private boolean canVisit(int[][] grid, int x, int y){
  if(x <0 || x >= grid.length
      || y <0 || y >=grid[x].length){
   return false;
  }

  return grid[x][y] == 0;
 }
}
