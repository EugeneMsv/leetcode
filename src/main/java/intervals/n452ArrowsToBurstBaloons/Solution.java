package intervals.n452ArrowsToBurstBaloons;

import java.util.Arrays;

public class Solution {

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> {
      int result = Integer.compare(a[0], b[0]);
      return result != 0 ? result
          : Integer.compare(a[1], b[1]);

    });

    int start = points[0][0];
    int end = points[0][1];
    int count = 1;
    for (int i = 1; i < points.length; i++) {
      int[] interval = points[i];
      if (interval[0] > end) {
        count++;
        start = interval[0];
        end = interval[1];
      } else {
        start = Math.max(start, interval[0]);
        end = Math.min(end, interval[1]);
      }
    }
    return count;
  }
}
