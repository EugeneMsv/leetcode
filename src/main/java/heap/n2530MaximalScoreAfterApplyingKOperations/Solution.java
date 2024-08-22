package heap.n2530MaximalScoreAfterApplyingKOperations;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

  public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : nums) {
      pq.offer(num);
    }

    long score = 0;
    for (int i = 0; i < k; i++) {
      int max = pq.poll();
      score += max;
      pq.offer(max / 3 + ((max % 3 == 0) ? 0 : 1));
    }

    return score;
  }
}