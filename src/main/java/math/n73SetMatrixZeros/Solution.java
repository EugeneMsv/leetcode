package math.n73SetMatrixZeros;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public void setZeroes(int[][] matrix) {

    Set<Integer> rows = new HashSet<>();
    Set<Integer> columns = new HashSet<>();

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        if (matrix[row][column] == 0) {
          rows.add(row);
          columns.add(column);
        }
      }
    }

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        if (rows.contains(row) || columns.contains(column)) {
          matrix[row][column] = 0;
        }
      }
    }

  }
}
