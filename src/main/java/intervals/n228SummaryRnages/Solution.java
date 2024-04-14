package intervals.n228SummaryRnages;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<String> summaryRanges(int[] nums) {
    if (nums.length == 0) {
      return List.of();
    }
    List<String> result = new LinkedList<>();
    int start = nums[0];
    int prev = start;
    for (int idx = 1; idx < nums.length; idx++) {
      int cur = nums[idx];
      if (cur == prev + 1) {
        prev = cur;
      } else {

        if (prev == start) {
          result.add(String.valueOf(start));
        } else {
          result.add(start + "->" + prev);
        }
        start = cur;
        prev = cur;
      }
    }
    if (prev == start) {
      result.add(String.valueOf(start));
    } else {
      result.add(start + "->" + prev);
    }
    return result;
  }
}
