package dynamic2d.n494TargetSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/target-sum/solutions/455024/dp-is-easy-5-steps-to-think-through
 * -dp-questions Useful
 */
public class Solution {

  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    return dfs(nums, 0, target, new HashMap<>());
  }

  private int dfs(int[] nums, int idx, int target, Map<Point, Integer> memo) {
    if (idx == nums.length - 1) {
      int result = 0;
      if (target - nums[idx] == 0) {
        result++;
      }
      if (target + nums[idx] == 0) {
        result++;
      }
      return result;
    }
    Point key = new Point(idx, target);

    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    int result = 0;
    result += dfs(nums, idx + 1, target - nums[idx], memo);
    result += dfs(nums, idx + 1, target + nums[idx], memo);
    memo.put(key, result);
    return result;
  }

  static class Point {

    int idx;
    int target;

    Point(int idx, int target) {
      this.idx = idx;
      this.target = target;
    }

    public boolean equals(Object o) {
      return ((Point) o).idx == idx && ((Point) o).target == target;
    }

    public int hashCode() {
      return Objects.hash(idx, target);
    }
  }
}
