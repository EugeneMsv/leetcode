package math.n3233FindTheCountOfNumbersWhichAreNotSpecial;

class Solution {

  public int nonSpecialCount(int l, int r) {
    int num = (int) Math.sqrt(r);
    int special = 0;
    while (num * num >= l) {
      boolean isSpecial = true;
      // check if num is prime (Only primes are special)
      for (int i = 2; i <= (int) Math.sqrt(num); i++) {
        if (num % i == 0) {
          isSpecial = false;
          break;
        }
      }
      if (isSpecial) {
        special++;
      }
      num--;
    }

    int result = r - l + 1 - special;
    if (l == 1) {
      result++;
    }
    return result;
  }
}
