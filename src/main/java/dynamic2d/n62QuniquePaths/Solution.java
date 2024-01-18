package dynamic2d.n62QuniquePaths;

public class Solution {

  public int uniquePaths(int m, int n) {
    return dp(0, 0, new int[m][n]);
  }

  private int dp(int row, int column, int[][] memo) {
    if (row >= memo.length || column >= memo[0].length) {
      return 0;
    }
    if (row == memo.length - 1) {
      return 1;
    }
    if (column == memo[0].length - 1) {
      return 1;
    }
    if (memo[row][column] > 0) {
      return memo[row][column];
    }

    int paths = dp(row + 1, column, memo) + dp(row, column + 1, memo);
    memo[row][column] = paths;
    return paths;
  }
}