package prefixsum.n724FindPivotIndex;

class Solution {

  public int pivotIndex(int[] nums) {
    int[] sum = new int[nums.length];
    int prev = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum[i] = prev;
      prev += nums[i];
    }
    int rightPrev = prev;
    prev = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum[i] == prev) {
        return i;
      }
      prev += nums[i];
    }
    return -1;
  }
}
