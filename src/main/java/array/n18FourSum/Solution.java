package array.n18FourSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    SortedMap<Integer, Integer> numsMap = new TreeMap<>();

    for (int num : nums) {
      numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
    }

    List<List<Integer>> result = new LinkedList<>();
    find(result, target, 4, new ArrayList<>(4), numsMap, numsMap.firstKey());
    return result;
  }

  // backtracking to level 1
  private void find(List<List<Integer>> result, long target, int level,

      List<Integer> candidate, SortedMap<Integer, Integer> numsMap, int starKey) {

    if (level == 1) {
      if (!safeLongToInt(target)) {
        return;
      }
      Integer freq = numsMap.get((int) target);
      if (freq != null && freq > 0 && target >= starKey) {
        candidate.add((int) target);
        result.add(List.copyOf(candidate));
        candidate.remove(candidate.size() - 1);
      }
      return;
    }

    for (Map.Entry<Integer, Integer> num : numsMap.tailMap(starKey).entrySet()) {
      int levelCandidate = num.getKey();
      int value = num.getValue();
      if (value > 0) {
        numsMap.put(levelCandidate, value - 1);
        candidate.add(levelCandidate);

        find(result, target - (long) levelCandidate, level - 1, candidate, numsMap, levelCandidate);

        candidate.remove(candidate.size() - 1);
        numsMap.put(levelCandidate, value);
      }

    }
  }

  public static boolean safeLongToInt(long l) {
    return !(l < Integer.MIN_VALUE || l > Integer.MAX_VALUE);
  }
}
