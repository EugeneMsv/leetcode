package binarysearch.n2226MaxCandiesAllocatedToKChildren;

public class Solution {

  public int maximumCandies(int[] candies, long k) {
    long sum = 0;

    for (int c : candies) {
      sum += (long) c;
    }
    int maxPerChild = (int) (sum / k);
    if (maxPerChild == 0) {
      return 0;
    }

    long left = 1;
    long right = maxPerChild;

    while (left < right) {
      long pivot = (right + left) / 2;
      if (canDivide(pivot, candies, k)) {
        left = pivot + 1;
      } else {
        right = pivot;
      }
    }

    return canDivide(left, candies, k) ? (int) left : (int) left - 1;
  }

  private boolean canDivide(long size, int[] candies, long k) {
    long accumulated = 0;
    for (int c : candies) {
      accumulated += (long) c / size;
    }
    return accumulated >= k;
  }
}