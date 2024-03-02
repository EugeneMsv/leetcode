package array.n2274MaxConsecutiveFloorsWithoutSpecials;

import java.util.Arrays;

public class Solution {

  public int maxConsecutive(int bottom, int top, int[] special) {
    Arrays.sort(special);
    int max = 0;
    int prev = bottom;
    int i = 1;

    for (int floor : special) {
      if (i == 1) {
        max = Math.max(max, floor - prev);
      } else {

        max = Math.max(max, floor - prev - 1);
      }
      prev = floor;
      i++;
    }

    return Math.max(max, top - prev);
  }
}
