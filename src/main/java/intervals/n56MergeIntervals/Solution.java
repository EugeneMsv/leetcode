package intervals.n56MergeIntervals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

  public int[][] merge(int[][] intervals) {
    Map<Integer, Integer> endByStart = new HashMap<>();

    int maxEnd = 0;
    int minStart = 0;
    // Fill the Map
    for (int idx = 0; idx < intervals.length; idx++) {
      int start = intervals[idx][0];
      int end = intervals[idx][1];
      Integer curEnd = endByStart.get(start);
      if (curEnd == null) {
        curEnd = end;
      } else {
        curEnd = Math.max(end, curEnd);
      }
      maxEnd = Math.max(maxEnd, curEnd);
      minStart = Math.min(minStart, start);
      endByStart.put(start, curEnd);
    }

    // Merge the rest
    List<int[]> result = new LinkedList<>();
    for (int position = minStart; position <= maxEnd; position++) {
      if (endByStart.containsKey(position)) {
        int[] mergedInterval = new int[2];
        mergedInterval[0] = position;

        // Find the max end for this start
        int end = endByStart.get(position);
        while (position <= end) {
          end = endByStart.containsKey(position)
              ? Math.max(end, endByStart.get(position))
              : end;
          position++;
        }
        mergedInterval[1] = end;
        result.add(mergedInterval);

        position--;
      }

    }
    return result.toArray(int[][]::new);
  }
}
