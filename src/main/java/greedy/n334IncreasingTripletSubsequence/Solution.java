package greedy.n334IncreasingTripletSubsequence;

class Solution {

  public boolean increasingTriplet(int[] nums) {
    return hasTriplet(nums, 1, nums[0], null, null);
  }

  private boolean hasTriplet(int[] nums, int idx, int first, Integer second, Integer oldSecond) {
    if (idx >= nums.length) {
      return false;
    }
    int cur = nums[idx];
    if (oldSecond != null && cur > oldSecond) {
      return true;
    }

    if (second == null) {
      return cur <= first
          ? hasTriplet(nums, idx + 1, cur, second, oldSecond)
          : hasTriplet(nums, idx + 1, first, cur, oldSecond);
    } else {
      if (cur > second) {
        return true;
      }
      if (cur > first) {
        return hasTriplet(nums, idx + 1, first, cur, oldSecond);
      } else {
        return hasTriplet(nums, idx + 1, cur, null, second);
      }
    }
  }
}