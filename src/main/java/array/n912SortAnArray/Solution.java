package array.n912SortAnArray;

class Solution {

  public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void quickSort(int[] nums, int begin, int end) {
    if (begin >= end) {
      return;
    }
    // to randomize pivot
    int pivotIdx = begin + (end - begin) / 2;
    int tmp = nums[end];
    nums[end] = nums[pivotIdx];
    nums[pivotIdx] = tmp;

    int pivot = nums[end];
    int right = begin;
    boolean same = true;
    for (int i = begin; i < end; i++) {
      int num = nums[i];
      if (num < pivot) {
        int temp = nums[right];
        nums[right] = num;
        nums[i] = temp;
        right++;
        same = false;
      } else if (num != pivot) {
        same = false;
      }
    }
    if (same) {
      return;
    }

    int temp = nums[right];
    nums[right] = pivot;
    nums[end] = temp;

    quickSort(nums, begin, right - 1);
    quickSort(nums, right + 1, end);
  }
}
