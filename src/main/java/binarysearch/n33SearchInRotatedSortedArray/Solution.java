package binarysearch.n33SearchInRotatedSortedArray;

public class Solution {

  public int search(int[] nums, int target) {
    int minIdx = findMinIdx(nums);
    System.out.println("minIdx =" + minIdx);
    int leftSearch = binarySearch(nums, target, 0, minIdx - 1);
    int rightSearch = binarySearch(nums, target, minIdx, nums.length - 1);
    return leftSearch >= 0 ? leftSearch
        : rightSearch >= 0 ? rightSearch
            : -1;
  }

  int binarySearch(int[] nums, int target, int start, int finish) {
    int begin = start;
    int end = finish;
    while (begin <= end) {
      if (end - begin <= 1) {
        return nums[end] == target ? end :
            nums[begin] == target ? begin
                : -1;
      }

      int pivot = (begin + end) / 2;
      if (target < nums[pivot]) {
        end = pivot;
      } else if (target > nums[pivot]) {
        begin = pivot;
      } else {
        return pivot;
      }
    }
    return -1;

  }

  int findMinIdx(int[] nums) {
    if (nums[nums.length - 1] >= nums[0]) {
      return 0;
    }
    int begin = 0;
    int end = nums.length - 1;

    while (begin < end) {
      if (end - begin <= 1) {
        return nums[end] >= nums[begin] ? begin : end;
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