package intervals.n436FindRightInterval;

import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Solution {

  public int[] findRightInterval(int[][] intervals) {
    NavigableMap<Integer, Set<Integer>> idxByStart = new TreeMap<>();

    for (int idx = 0; idx < intervals.length; idx++) {
      Set<Integer> idxs = idxByStart.get(intervals[idx][0]);
      if (idxs == null) {
        idxs = new HashSet<>();
        idxByStart.put(intervals[idx][0], idxs);
      }
      idxs.add(idx);
    }

    int[] result = new int[intervals.length];

    for (Map.Entry<Integer, Set<Integer>> entry : idxByStart.entrySet()) {
      for (Integer idx : entry.getValue()) {
        result[idx] = -1;
        if (intervals[idx][0] == intervals[idx][1]) {
          result[idx] = idx;
          continue;
        }
        int minRightStart = intervals[idx][1];
        Map.Entry<Integer, Set<Integer>> higherEntry = idxByStart.ceilingEntry(minRightStart);
        if (higherEntry != null) {
          result[idx] = higherEntry.getValue().iterator().next();
        }
      }
    }
    return result;

  }
}