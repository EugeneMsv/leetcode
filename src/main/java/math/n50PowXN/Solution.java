package math.n50PowXN;

public class Solution {

  public double myPow(double x, int n) {
    if (x == 1.00F) {
      return 1.0;
    }
    return calc(x, n);
  }

  private double calc(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }

    if (n % 2 == 0) {
      return calc(x * x, n / 2);
    } else {
      return x * calc(x, n - 1);
    }
  }
}
