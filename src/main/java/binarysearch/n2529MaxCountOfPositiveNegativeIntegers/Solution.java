package binarysearch.n2529MaxCountOfPositiveNegativeIntegers;

public class Solution {

  public int maximumCount(int[] nums) {
    int zeroPosition = findZero(nums);

    int lastNegative = zeroPosition;

    while (lastNegative >= 0 && nums[lastNegative] >= 0) {
      lastNegative--;
    }

    int firstPositive = zeroPosition;
    while (firstPositive < nums.length && nums[firstPositive] <= 0) {
      firstPositive++;
    }

    return Math.max(lastNegative + 1, nums.length - firstPositive);
  }

  private int findZero(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {

      int pivot = (right + left) / 2;
      if (nums[pivot] == 0) {
        return pivot;
      }
      if (nums[pivot] > 0) {
        right = pivot;
      } else {
        left = pivot + 1;
      }
    }
    return left;
  }

}