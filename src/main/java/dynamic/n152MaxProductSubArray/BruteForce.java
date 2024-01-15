package dynamic.n152MaxProductSubArray;

public class BruteForce {

  public int maxProduct(int[] nums) {
    return dp(nums, nums.length - 1);
  }

  private int dp(int[] nums, int end) {
    if (end == 0) {
      return nums[end];
    }

    int prevProduct = dp(nums, end - 1);

    if (nums[end] == 0 && prevProduct > 0) {
      return prevProduct;
    }

    int product = nums[end];
    int maxProduct = nums[end];
    for (int i = end - 1; i >= 0; i--) {
      product *= nums[i];
      if (product > maxProduct) {
        maxProduct = product;
      }
    }
    int result = Math.max(prevProduct, maxProduct);
    return result;
  }
}
