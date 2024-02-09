package math.n48RotateImage;

public class Solution {

  public void rotate(int[][] matrix) {
    int l = matrix.length - 1;
    for (int i = 0; i < matrix.length; i++) {

      for (int j = 0; j < matrix[i].length; j++) {
        if (-1000 <= matrix[i][j] && matrix[i][j] <= 1000) {
          int x = j;
          int y = l - i;
          int value = matrix[i][j];
          while (!(x == i && y == j)) {
            int temp = matrix[x][y];
            matrix[x][y] = 10000 + value;
            value = temp;
            temp = x;
            x = y;
            y = l - temp;
          }
          matrix[x][y] = 10000 + value;

        }

      }
    }

    for (int i = 0; i < matrix.length; i++) {

      for (int j = 0; j < matrix[i].length; j++) {
        matrix[i][j] -= 10000;

      }
    }

  }
}