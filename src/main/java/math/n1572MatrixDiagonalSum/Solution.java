package math.n1572MatrixDiagonalSum;

class Solution {

  public int diagonalSum(int[][] mat) {
    int sum = 0;
    for (int row = 0; row < mat.length; row++) {
      int columnR = mat[row].length - row - 1;
      int columnL = row;
      if (columnL != columnR) {
        sum += mat[row][columnL];
        sum += mat[row][columnR];
      } else {
        sum += mat[row][columnL];
      }

    }
    return sum;
  }
}
