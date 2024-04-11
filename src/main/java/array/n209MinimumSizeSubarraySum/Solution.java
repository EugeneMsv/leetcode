package array.n209MinimumSizeSubarraySum;

public class Solution {

  public int minSubArrayLen(int target, int[] nums) {
    int sum = 0;
    int left = 0;
    int right = 0;
    int minLength = Integer.MAX_VALUE;

    while (right < nums.length && left < nums.length) {
      sum += nums[right];
      if (sum < target) {
        right++;
        continue;
      }

      minLength = Math.min(minLength, right - left + 1);

      while (sum > target && left <= right) {
        sum -= nums[left];
        left++;
      }

      if (sum < target && left > 0) {
        left--;
        sum += nums[left];
      }
      minLength = Math.min(minLength, right - left + 1);
      right++;
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}