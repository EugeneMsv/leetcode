package greedy.n55JumpGame;

public class Solution {

  /**
   * Use a variable to hold the furthest point we can reach so far, ie. furthest = max(furthest,
   * i+nums[i]). Then think of a way to use it for judging if we can get to the end.
   */
  public boolean canJump(int[] nums) {

    int maxDistance = 0;

    for (int i = 0; i < nums.length; i++) {
      if (maxDistance >= i) {
        maxDistance = Math.max(maxDistance, i + nums[i]);
      } else {
        continue;
      }
    }

    return maxDistance >= nums.length - 1;

  }
}
