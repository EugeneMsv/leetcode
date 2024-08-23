package dynamic.n1696JumpGame6;

import java.util.PriorityQueue;

class Solution {

  public int maxResult(int[] nums, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> b[1] - a[1]);
    pq.offer(new int[]{0, nums[0]});

    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      while (pq.peek()[0] < i - k) {
        pq.poll();
      }

      max = nums[i] + pq.peek()[1];
      pq.offer(new int[]{i, max});
    }

    return max;
  }
}
