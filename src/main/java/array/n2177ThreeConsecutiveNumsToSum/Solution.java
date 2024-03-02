package array.n2177ThreeConsecutiveNumsToSum;

public class Solution {

  public long[] sumOfThree(long num) {
    long rest = (num - 3) % 3;
    long x = (num - 3) / 3;

    return rest == 0 ? new long[]{x, x + 1, x + 2} : new long[]{};
  }
}
