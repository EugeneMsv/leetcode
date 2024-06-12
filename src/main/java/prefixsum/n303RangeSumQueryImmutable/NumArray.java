package prefixsum.n303RangeSumQueryImmutable;

class NumArray {

  int sum[];

  public NumArray(int[] nums) {
    sum = new int[nums.length];
    int prev = 0;
    for (int i = 0; i < nums.length; i++) {
      prev += nums[i];
      sum[i] = prev;
    }
  }

  public int sumRange(int left, int right) {
    return sum[right] - ((left > 0) ? sum[left - 1] : 0);
  }
}
