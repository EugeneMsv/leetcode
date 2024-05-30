package advancedgraph.n743NetworkDelayTime;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Dijkstra’s Algorithm
public class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {

    Map<Integer, List<int[]>> graph = new HashMap<>();

    for (int[] time : times) {
      graph.computeIfAbsent(time[0], key -> new LinkedList<>())
          .add(new int[]{time[1], time[2]});
    }

    // Value is the min time from k to each other node (The shortest path from k)
    Map<Integer, Integer> processed = new HashMap<>();
    processed.put(k, 0);

    // int[0] = node num, int[1] = time from k. Queue sorted by time ASC
    PriorityQueue<int[]> timeNodes = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    int curNode = k;

    while (processed.size() < n) {

      int timeToCur = processed.get(curNode);
      // Add all neighbour of the curNode with ther times
      for (int[] neighbour : graph.getOrDefault(curNode, List.of())) {
        int neighbourId = neighbour[0];
        int timeToNeighbour = neighbour[1];
        if (!processed.containsKey(neighbourId)) {
          timeNodes.offer(new int[]{neighbourId, timeToNeighbour + timeToCur});
        }
      }

      // Pick the smallest by time next node until we meet unprocessed node
      int[] nextCandidate = timeNodes.poll();

      while (nextCandidate != null && processed.containsKey(nextCandidate[0])) {
        nextCandidate = timeNodes.poll();
      }

      if (nextCandidate == null || processed.containsKey(nextCandidate[0])) {
        // can't reach all nodes
        return -1;
      }

      curNode = nextCandidate[0];
      processed.put(nextCandidate[0], nextCandidate[1]);
    }

    // The minimun time to reach all the nodes, is amount of time required to reach the last graph node.
    int max = 0;

    for (Integer time : processed.values()) {
      max = Math.max(time, max);
    }

    return max;
  }
}
