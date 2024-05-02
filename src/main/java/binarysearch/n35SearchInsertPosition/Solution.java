package binarysearch.n35SearchInsertPosition;

public class Solution {

  public int searchInsert(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int pivot = (right + left) / 2;
      pivot += ((right + left) % 2 == 0 ? 0 : 1);

      if (target == nums[pivot]) {
        return pivot;
      }
      if (target < nums[pivot]) {
        right = pivot - 1;
      } else {
        left = pivot;
      }
    }

    return target > nums[left] ? left + 1 : left;
  }
}
