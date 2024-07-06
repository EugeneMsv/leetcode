package graph.n1926NearestExitFromEntranceMaze;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
 public int nearestExit(char[][] maze, int[] entrance) {

  Queue<int[]> bfs =  new LinkedList<>();
  bfs.offer(entrance);

  int steps = 0;

  while(!bfs.isEmpty()){
   int size = bfs.size();

   for(int i = 0; i < size; i++){
    int[]  position = bfs.poll();
    // skip walls
    if(maze[position[0]][position[1]] != '.'){
     continue;
    }
    if((position[0] ==0 || position[0]== maze.length-1
        || position[1] ==0  || position[1] == maze[0].length -1)){

     if(!(position[0] == entrance[0] && position[1] == entrance[1])){
      return steps;
     }

    }
    tryAddNext(bfs, position[0]-1, position[1], maze);
    tryAddNext(bfs, position[0]+1, position[1], maze);
    tryAddNext(bfs, position[0], position[1]-1, maze);
    tryAddNext(bfs, position[0], position[1]+1, maze);
    maze[position[0]][position[1]] ='$';

   }

   // for(int i =0; i < maze.length; i++){
   //     System.out.println(Arrays.toString(maze[i]));
   // }
   // System.out.println();
   steps++;
  }

  return -1;
 }

 private void tryAddNext(Queue<int[]> bfs, int row, int column, char[][] maze){
  if(row < 0 || column <0
      || row >=maze.length || column >= maze[0].length
      || maze[row][column] == '$'){
   return;
  }
  bfs.offer(new int[]{row, column});
 }
}
