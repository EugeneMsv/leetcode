package bitmanipulation.n338CountingBits;

public class Solution {

  public int[] countBits(int n) {
    if (n == 0) {
      return new int[]{0};
    }
    if (n == 1) {
      return new int[]{0, 1};
    }

    int multiplierBy2 = 2;
    int nextMultiplyAt = multiplierBy2 * 2;
    int i = 2;
    int[] a = new int[n + 1];
    a[0] = 0;
    a[1] = 1;
    while (i <= n) {
      if (i == nextMultiplyAt) {
        multiplierBy2 *= 2;
        nextMultiplyAt *= 2;
      }
      a[i] = 1 + a[i - multiplierBy2];
      i++;
    }
    return a;
  }
}