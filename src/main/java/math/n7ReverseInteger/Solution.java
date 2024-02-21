package math.n7ReverseInteger;

public class Solution {

  public int reverse(int x) {
    int sign = x > 0 ? 1 : -1;
    int result = 0;
    int multiplier = 1;
    x = Math.abs(x);
    while (x > 0) {
      if (x < 10) {
        if (result > Integer.MAX_VALUE / 10

            || (result == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)) {
          return 0;
        }
      }
      result *= multiplier;
      int lastDigit = x % 10;
      result += lastDigit;
      x = x / 10;
      multiplier = 10;

    }
    return result * sign;
  }
}