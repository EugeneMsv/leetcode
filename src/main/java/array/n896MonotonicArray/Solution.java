package array.n896MonotonicArray;

class Solution {

  public boolean isMonotonic(int[] nums) {

    boolean decreasing = nums[0] >= nums[nums.length - 1];

    int prev = nums[0];

    for (int i = 1; i < nums.length; i++) {
      boolean correct = decreasing ? prev >= nums[i] : prev <= nums[i];
      if (!correct) {
        return false;
      }
      prev = nums[i];
    }

    return true;
  }
}
