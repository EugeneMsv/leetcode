package slidingwindow.n1493LongestSubbarayOf1sAfterDeletingOneElement;

class Solution {

  public int longestSubarray(int[] nums) {

    int skipped = -1;

    int left, right, cur, max;
    left = right = cur = max = 0;

    while (right < nums.length) {
      int bit = nums[right];
      if (bit == 1) {
        cur++;
        right++;
        max = Math.max(max, cur);
        continue;
      }

      if (skipped < 0) {
        skipped = right;
        right++;
        continue;
      }

      while (left <= skipped && left < right) {
        left++;
        cur--;
      }
      cur++;
      skipped = -1;

    }

    return max == nums.length ? max - 1 : max;
  }
}
