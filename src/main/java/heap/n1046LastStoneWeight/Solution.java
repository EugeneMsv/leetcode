package heap.n1046LastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

  public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, Collections.reverseOrder());

    for (int i = 0; i < stones.length; i++) {
      heap.add(stones[i]);
    }

    while (heap.size() > 1) {
      int y = heap.poll();
      int x = heap.poll();
      if (y - x > 0) {
        heap.add(y - x);
      }
    }

    return heap.isEmpty() ? 0 : heap.poll();
  }
}
