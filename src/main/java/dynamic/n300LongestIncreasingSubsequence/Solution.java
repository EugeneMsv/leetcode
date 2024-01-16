package dynamic.n300LongestIncreasingSubsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int lengthOfLIS(int[] nums) {
    Map<Integer, Integer> memo = new HashMap<>();
    int overallLongest = 0;
    for (int end = nums.length - 1; end >= 0; end--) {
      overallLongest = Math.max(overallLongest, dp(nums, end, memo));
    }
    return overallLongest;
  }

  // Longest if ends in "end"
  private int dp(int[] nums, int end, Map<Integer, Integer> memo) {
    if (end == 0) {
      return 1;
    }

    if (end < 0) {
      return 0;
    }

    if (memo.containsKey(end)) {
      return memo.get(end);
    }

    int currentEnd = nums[end];
    int longest = 1;
    for (int prevEnd = end - 1; prevEnd >= 0; prevEnd--) {
      if (currentEnd > nums[prevEnd]) {
        int prevLongest = dp(nums, prevEnd, memo);
        longest = Math.max(longest, prevLongest + 1);
      }
    }
    memo.put(end, longest);
    return longest;
  }
}
