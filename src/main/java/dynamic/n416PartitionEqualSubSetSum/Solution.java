package dynamic.n416PartitionEqualSubSetSum;

public class Solution {

  Boolean memo[][];

  public boolean canPartition(int[] nums) {
    int sum = 0;
    int n = nums.length;

    for (int i : nums) {
      sum += i;
    }

    if (sum % 2 != 0) {
      return false;
    }

    sum /= 2;

    memo = new Boolean[n + 1][sum + 1];

    return subsetSum(nums, n - 1, sum);
  }

  boolean subsetSum(int[] nums, int pos, int sum) {
    if (sum == 0) {
      return true;
    } else if (pos < 0 || sum < 0) {
      return false;
    }

    if (memo[pos][sum] != null) {
      return memo[pos][sum];
    }

    return memo[pos][sum] = subsetSum(nums, pos - 1, sum - nums[pos])
        || subsetSum(nums, pos - 1, sum);

  }

}
