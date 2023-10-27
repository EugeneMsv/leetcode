package binarysearch.n74Search2DMatrix;

public class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int columns = matrix[0].length;
    int rows = matrix.length;
    int row = findRow(matrix, target, 0, rows - 1);
    if (row < 0) {
      return false;
    }

    return existsInRow(matrix[row], target, 0, columns - 1);
  }

  private int findRow(int[][] matrix, int target, int begin, int end) {
    if (end - begin <= 1) {
      if (target < matrix[begin][0]) {
        return -1;
      }
      return target >= matrix[end][0] ? end : begin;
    }

    int pivot = (end + begin) / 2;
    int pivotValue = matrix[pivot][0];
    return target <= pivotValue
        ? findRow(matrix, target, begin, pivot)
        : findRow(matrix, target, pivot, end);

  }

  private boolean existsInRow(int[] row, int target, int begin, int end) {
    if (end - begin <= 1) {
      return row[begin] == target || row[end] == target;
    }

    int pivot = (end + begin) / 2;
    int pivotValue = row[pivot];
    return target <= pivotValue
        ? existsInRow(row, target, begin, pivot)
        : existsInRow(row, target, pivot, end);

  }

}
