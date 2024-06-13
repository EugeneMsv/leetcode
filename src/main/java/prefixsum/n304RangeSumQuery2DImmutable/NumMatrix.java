package prefixsum.n304RangeSumQuery2DImmutable;

class NumMatrix {

  int[][] sumByRow;
  int[][] sumByRectangle;
  int[][] matrix;

  public NumMatrix(int[][] matrix) {
    this.matrix = matrix;
    sumByRow = new int[matrix.length][matrix[0].length];
    sumByRectangle = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {

      for (int j = 0; j < matrix[i].length; j++) {
        sumByRow[i][j] = (j - 1) >= 0 ? sumByRow[i][j - 1] + matrix[i][j] : matrix[i][j];
        sumByRectangle[i][j] =
            (i - 1) >= 0 ? sumByRectangle[i - 1][j] + sumByRow[i][j] : sumByRow[i][j];
        // System.out.print(sumByRectangle[i][j]+", ");
      }
      // System.out.println();
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row1 == row2 && col1 == col2) {
      return matrix[row1][col1];
    }

    if (row1 == 0 && col1 == 0) {
      return sumByRectangle[row2][col2];
    }

    return sumByRectangle[row2][col2]
        - ((row1 - 1) >= 0 ? sumByRectangle[row1 - 1][col2] : 0)
        - ((col1 - 1) >= 0 ? sumByRectangle[row2][col1 - 1] : 0)

        + ((row1 - 1) >= 0 && (col1 - 1) >= 0 ? sumByRectangle[row1 - 1][col1 - 1] : 0);

  }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new
 * NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
