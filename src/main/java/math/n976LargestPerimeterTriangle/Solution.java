package math.n976LargestPerimeterTriangle;

import java.util.Arrays;

class Solution {

  public int largestPerimeter(int[] nums) {

    Arrays.sort(nums);
    for (int i = nums.length - 3; i >= 0; i--) {
      int a = nums[i + 2];
      int b = nums[i + 1];
      int c = nums[i];
      if (a < b + c) {
        return a + b + c;
      }
    }
    return 0;
  }
}
