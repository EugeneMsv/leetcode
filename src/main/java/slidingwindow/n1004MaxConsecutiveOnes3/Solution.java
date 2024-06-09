package slidingwindow.n1004MaxConsecutiveOnes3;

class Solution {

  public int longestOnes(int[] nums, int k) {

    if (k == 0) {
      int cur = 0;
      int max = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
          cur = 0;
        } else {
          cur++;
        }
        max = Math.max(cur, max);
      }
      return max;
    }

    int left, right, max, cur;
    left = right = max = cur = 0;
    int notUsed = k;

    while (right < nums.length) {
      // System.out.println("Begin nums=%s, left=%s, right=%s".formatted(Arrays.toString(nums), left, right));
      int bit = nums[right];
      if (bit == 1) {
        cur++;
        right++;
        max = Math.max(cur, max);
        continue;
      }
      // if bit == 0;
      if (notUsed > 0) {
        nums[right] = -1;
        cur++;
        max = Math.max(max, cur);
        right++;
        notUsed--;
        continue;
      }
      // if bit == 0 && notUsed ==0;

      while (notUsed == 0 && left < right) {
        notUsed += nums[left] == -1 ? 1 : 0;
        nums[left] = nums[left] == -1 ? 0 : 1;
        cur--;
        left++;
      }
    }
    return max;
  }
}