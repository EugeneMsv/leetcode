package dynamic2d.nMinimum931FallingPathSum;

class Solution {

  public int minFallingPathSum(int[][] matrix) {

    int min = Integer.MAX_VALUE;
    Integer[][] memo = new Integer[matrix.length][matrix[0].length];
    for (int j = 0; j < matrix[0].length; j++) {
      min = Math.min(min, dfs(memo, matrix, 0, j));
    }

    return min;
  }

  private int dfs(Integer[][] memo, int[][] matrix, int x, int y) {
    Integer result = memo[x][y];
    if (result != null) {
      return result;
    }

    if (x + 1 >= matrix.length) {
      memo[x][y] = matrix[x][y];
      return matrix[x][y];
    }
    int min = dfs(memo, matrix, x + 1, y);
    if (y - 1 >= 0) {
      min = Math.min(min, dfs(memo, matrix, x + 1, y - 1));
    }

    if (y + 1 < matrix[x].length) {
      min = Math.min(min, dfs(memo, matrix, x + 1, y + 1));
    }
    result = min + matrix[x][y];
    memo[x][y] = result;
    return result;

  }
}