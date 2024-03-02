package array.n2906ConstructProductMatrix;

import java.util.Arrays;

public class Solution {

  public int[][] constructProductMatrix(int[][] grid) {

    int[][] result = new int[grid.length][grid[0].length];

    long prefixProduct = 1;
    long suffixProduct = 1;
    long mod = 12345;
    int n = grid.length;
    int m = grid[0].length;

    for (int i = 0; i < result.length; i++) {
      Arrays.fill(result[i], 1);
    }

    for (int i = 0; i < n; i++) {

      for (int j = 0; j < m; j++) {

        result[i][j] = (int) (prefixProduct * result[i][j] % mod);

        result[n - i - 1][m - j - 1] = (int) (suffixProduct * result[n - i - 1][m - j - 1] % mod);

        prefixProduct = prefixProduct * grid[i][j] % mod;
        suffixProduct = suffixProduct * grid[n - i - 1][m - j - 1] % mod;
      }
    }
    return result;
  }
}
