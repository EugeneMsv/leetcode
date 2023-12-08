package graph.n542Matrix01;

public class Solution {

  public int[][] updateMatrix(int[][] matrix) {
    if (matrix.length == 0) {
      return matrix;
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1 && !hasNeiberZero(i, j, matrix)) {
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) {
          dfs(matrix, i, j, -1);
        }
      }
    }

    return matrix;
  }

  private void dfs(int[][] matrix, int x, int y, int val) {
    if (x < 0 || y < 0
        || x >= matrix.length
        || y >= matrix[0].length
        // If it was updated from another neighbhour who is closer to 0
        || matrix[x][y] <= val) {
      return;
    }

    //  System.out.println("----------------------");
    // for(int i = 0; i < matrix.length; i++){
    //     for(int j = 0; j < matrix[i].length; j++){
    //         System.out.print(matrix[i][j]+" ");
    //     }
    //      System.out.println();
    // }

    if (val > 0) {
      matrix[x][y] = val;
    }
    int nextVal = matrix[x][y] + 1;
    dfs(matrix, x + 1, y, nextVal);
    dfs(matrix, x - 1, y, nextVal);
    dfs(matrix, x, y + 1, nextVal);
    dfs(matrix, x, y - 1, nextVal);

  }

  private boolean hasNeiberZero(int x, int y, int[][] matrix) {
    if (x > 0 && matrix[x - 1][y] == 0) {
      return true;
    }
    if (x < matrix.length - 1 && matrix[x + 1][y] == 0) {
      return true;
    }
    if (y > 0 && matrix[x][y - 1] == 0) {
      return true;
    }
    if (y < matrix[0].length - 1 && matrix[x][y + 1] == 0) {
      return true;
    }

    return false;
  }
}
