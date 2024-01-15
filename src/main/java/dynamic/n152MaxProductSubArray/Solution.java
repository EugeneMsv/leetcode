package dynamic.n152MaxProductSubArray;

public class Solution {

  private static int max;

  public int maxProduct(int[] nums) {
    max = Integer.MIN_VALUE;
    dp(nums, nums.length - 1);
    return max;
  }

  private int[] dp(int[] nums, int end) {
    int value = nums[end];
    Solution.max = Math.max(value, max);
    if (end == 0) {
      return value == 0 ? new int[]{1, 1} : new int[]{value, value};
    }

    int[] prevProduct = dp(nums, end - 1);
    if (value == 0) {
      return new int[]{1, 1};
    }

    int[] currentProduct = new int[]{
        Math.max(value, Math.max(value * prevProduct[0], value * prevProduct[1])),
        Math.min(value, Math.min(value * prevProduct[0], value * prevProduct[1]))};
    Solution.max = Math.max(currentProduct[0], max);
    return currentProduct;
  }
}
