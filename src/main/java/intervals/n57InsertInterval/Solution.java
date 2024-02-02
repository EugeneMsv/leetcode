package intervals.n57InsertInterval;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public int[][] insert(int[][] intervals, int[] newInterval) {

    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }
    List<int[]> result = new LinkedList<>();
    int idx = 0;
    while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
      result.add(intervals[idx]);
      idx++;
    }

    int[] mergedInterval = new int[]{newInterval[0], newInterval[1]};
    while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
      mergedInterval[0] = Math.min(mergedInterval[0], intervals[idx][0]);
      mergedInterval[1] = Math.max(mergedInterval[1], intervals[idx][1]);
      idx++;
    }
    result.add(mergedInterval);

    while (idx < intervals.length) {
      result.add(intervals[idx]);
      idx++;
    }
    return result.toArray(int[][]::new);
  }

}
