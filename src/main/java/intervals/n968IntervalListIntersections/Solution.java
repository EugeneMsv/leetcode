package intervals.n968IntervalListIntersections;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  private static final int[] NONE = new int[]{-1, -1};

  public int[][] intervalIntersection(int[][] first, int[][] second) {
    int i = 0;
    int j = 0;
    List<int[]> intersection = new LinkedList<>();

    while (i < first.length && j < second.length) {
      int[] a = first[i];
      int[] b = second[j];
      int[] abIntersection = calcIntersection(a, b);
      if (abIntersection != NONE) {
        intersection.add(abIntersection);
      }
      if (a[1] >= b[1]) {
        j++;
      } else {
        i++;
      }

    }
    return intersection.toArray(int[][]::new);
  }

  private int[] calcIntersection(int[] first, int[] second) {
    if (second[0] <= first[0] && first[0] <= second[1]
        || first[0] <= second[0] && second[0] <= first[1]) {
      return new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])};
    } else {
      return NONE;
    }
  }
}
