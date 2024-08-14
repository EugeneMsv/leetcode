package math.n1232CheckIfItIsAStraightLine;

class Solution {

  public boolean checkStraightLine(int[][] point) {
    if (point.length == 2) {
      return true;
    }

    if (point[1][0] == point[0][0]) {
      int x = point[1][0];
      for (int i = 2; i < point.length; i++) {
        if (x != point[i][0]) {
          return false;
        }
      }
      return true;
    }

    double a = ((double) point[1][1] - point[0][1]) / (point[1][0] - point[0][0]);
    double b = (double) point[0][1] - a * point[0][0];
    for (int i = 2; i < point.length; i++) {
      double diff = (double) point[i][1] - a * point[i][0] - b;
      if (Math.abs(diff) >= 10e-5) {
        return false;
      }
    }

    return true;

  }
}
