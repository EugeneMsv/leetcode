package graph.n994RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private static final int[] DELIMITER = new int[]{-1, -1};

  public int orangesRotting(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    Queue<int[]> rotten = new LinkedList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2) {
          rotten.offer(new int[]{i, j});
        }
      }
    }
    rotten.offer(DELIMITER);
    int minutes = 0;

    while (!rotten.isEmpty()) {
      int[] rottenOrange = null;

      while (rottenOrange != DELIMITER) {
        rottenOrange = rotten.poll();
        if (rottenOrange == DELIMITER) {
          break;
        }

        int i = rottenOrange[0];
        int j = rottenOrange[1];

        if (visited[i][j]) {
          // if it was laready visited from another neigbour
          continue;
        }
        visited[i][j] = true;
        tryAddNextRotten(visited, grid, i + 1, j, rotten);
        tryAddNextRotten(visited, grid, i - 1, j, rotten);
        tryAddNextRotten(visited, grid, i, j + 1, rotten);
        tryAddNextRotten(visited, grid, i, j - 1, rotten);

      }

      if (!rotten.isEmpty()) {
        rotten.offer(DELIMITER);
        minutes++;
      }
    }

    System.out.println("Minutes " + minutes);
    // check if there is any fresh than return -1
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          return -1;
        }
      }
    }

    return minutes;
  }

  private void tryAddNextRotten(boolean[][] visited, int[][] grid, int i, int j,
      Queue<int[]> rotten) {
    if (i < 0 || j < 0
        || i >= grid.length || j >= grid[i].length) {
      return;
    }

    if (visited[i][j] || grid[i][j] != 1) {
      return;
    }
    grid[i][j] = 2;
    rotten.offer(new int[]{i, j});
  }
}