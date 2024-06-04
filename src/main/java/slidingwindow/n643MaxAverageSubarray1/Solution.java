package slidingwindow.n643MaxAverageSubarray1;

public class Solution {

  public double findMaxAverage(int[] nums, int k) {
    double maxAverage = -10e4;

    int left = 0;
    int right = k - 1;
    int sum = 0;
    for (int i = left; i <= right; i++) {
      sum += nums[i];
    }
    maxAverage = (double) sum / k;

    while (right + 1 < nums.length) {

      sum -= nums[left++];
      sum += nums[++right];
      maxAverage = Math.max(maxAverage, (double) sum / k);

    }

    return maxAverage;
  }
}
