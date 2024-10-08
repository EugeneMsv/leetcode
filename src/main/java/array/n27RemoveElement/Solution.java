package array.n27RemoveElement;

class Solution {

  public int removeElement(int[] nums, int val) {
    int left = 0;
    int right = 0;

    while (right < nums.length) {
      if (nums[right] != val) {
        nums[left] = nums[right];
        left++;
      }
      right++;

    }

    return left;
  }
}
