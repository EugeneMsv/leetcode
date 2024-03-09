package binarysearch.n2517MaxTastinessOfCandyBasket;

import java.util.Arrays;

public class Solution {

  public int maximumTastiness(int[] price, int k) {
    Arrays.sort(price);

    int maxDiff = price[price.length - 1] - price[0];
    System.out.println("maxDiff=%s".formatted(maxDiff));

    int left = 0;
    int right = maxDiff;

    while (left < right) {
      int pivot = (right + left) / 2;
      if (check(pivot, price, k)) {
        left = pivot + 1;
      } else {
        right = pivot;
      }

    }

    return check(left, price, k) ? left : left - 1;
  }

  private boolean check(int tastiness, int[] price, int k) {
    int bucketSize = 1;
    int lastPicked = price[0];
    int i = 1;
    while (i < price.length && bucketSize < k) {
      if (price[i] - lastPicked >= tastiness) {
        bucketSize++;
        lastPicked = price[i];
      }
      i++;
    }
    return bucketSize == k;
  }
}
