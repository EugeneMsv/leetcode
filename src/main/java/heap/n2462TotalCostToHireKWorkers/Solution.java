package heap.n2462TotalCostToHireKWorkers;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

  public long totalCost(int[] costs, int k, int candidates) {
    Comparator<int[]> comparator = (a, b) -> {
      int first = Integer.compare(a[0], b[0]);
      return first == 0 ? Integer.compare(a[1], b[1])
          : first;
    };

    // In case we need a simplfied version with simple queue
    if (candidates * 2 >= costs.length) {
      PriorityQueue<int[]> workers = new PriorityQueue<>(comparator);

      for (int i = 0; i < costs.length; i++) {
        workers.offer(new int[]{costs[i], i});
      }

      long sum = 0;
      for (int i = 0; i < k; i++) {
        sum += workers.poll()[0];
      }
      return sum;

    }

    PriorityQueue<int[]> workers = new PriorityQueue<>(comparator);

    for (int i = 0; i < candidates; i++) {
      workers.offer(new int[]{costs[i], i, 1});
    }

    for (int i = costs.length - 1; i > costs.length - 1 - candidates; i--) {
      workers.offer(new int[]{costs[i], i, 0});
    }

    int leftEnd = candidates - 1;
    int rightStart = costs.length - candidates;

    long sum = 0;
    for (int j = 0; j < k; j++) {
      int[] worker = workers.poll();
      sum += worker[0];
      if (leftEnd + 1 < rightStart) {
        int side = worker[2];
        if (side == 1) {
          leftEnd++;
          workers.offer(new int[]{costs[leftEnd], leftEnd, 1});
        } else {
          rightStart--;
          workers.offer(new int[]{costs[rightStart], rightStart, 0});
        }
      }
    }

    return sum;
  }
}
