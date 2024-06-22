package queue.n933NumberOfRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

  private Queue<Integer> time;

  public RecentCounter() {
    this.time = new LinkedList<>();
  }

  public int ping(int t) {
    time.offer(t);
    while (time.peek() < t - 3000) {
      time.poll();
    }
    return time.size();
  }
}

/**
 * Your RecentCounter object will be instantiated and called as such: RecentCounter obj = new
 * RecentCounter(); int param_1 = obj.ping(t);
 */