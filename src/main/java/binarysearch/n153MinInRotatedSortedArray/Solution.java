package binarysearch.n153MinInRotatedSortedArray;

public class Solution {

  public int findMin(int[] nums) {

    if (nums[0] <= nums[nums.length - 1]) {
      return nums[0];
    }

    int begin = 0;
    int end = nums.length - 1;

    while (begin < end) {
      if (end - begin <= 1) {
        return nums[end];
      }

      int pivot = (end + begin) / 2;
      if (nums[pivot] < nums[end]) {
        end = pivot;
      } else {
        begin = pivot;
      }
    }
    return -1;

  }

}
