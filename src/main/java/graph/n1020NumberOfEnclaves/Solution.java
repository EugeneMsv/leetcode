package graph.n1020NumberOfEnclaves;

public class Solution {

  public int numEnclaves(int[][] grid) {
    int enclaves = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          int num = calc(grid, i, j);
          if (num > 0) {
            enclaves += num;
          }
        }
      }
    }
    return enclaves;
  }

  int calc(int[][] grid, int i, int j) {
    if (i < 0 || j < 0
        || i >= grid.length
        || j >= grid[i].length) {
      return -1;
    }

    int state = grid[i][j];
    if (state == 0) {
      return 0;
    }
    if (state == 2) {
      return 0;
    }
    grid[i][j] = 2;

    int down = calc(grid, i + 1, j);
    int top = calc(grid, i - 1, j);
    int right = calc(grid, i, j + 1);
    int left = calc(grid, i, j - 1);

    if (down == -1 || top == -1
        || left == -1 || right == -1) {
      return -1;
    }

    return down + top + left + right + 1;

  }
}
