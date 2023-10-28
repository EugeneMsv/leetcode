package binarysearch.n875KokoEatingBananas;

public class Solution {

  public int minEatingSpeed(int[] piles, int h) {
    int maxK = 1;
    for (int pile : piles) {
      maxK = Math.max(pile, maxK);
    }

    return searchK(piles, h, 1, maxK);
  }

  int calcHoursToEat(int[] piles, int k) {
    int h = 0;
    for (int pile : piles) {
      h += pile / k + (pile % k > 0 ? 1 : 0);
    }
    return h;
  }

  int searchK(int[] piles, int h, int minK, int maxK) {
    if (maxK - minK <= 1) {
      return calcHoursToEat(piles, minK) <= h ? minK
          : maxK;
    }

    int pivot = (maxK + minK) / 2;
    return calcHoursToEat(piles, pivot) > h
        ? searchK(piles, h, pivot, maxK)
        : searchK(piles, h, minK, pivot);
  }
}
