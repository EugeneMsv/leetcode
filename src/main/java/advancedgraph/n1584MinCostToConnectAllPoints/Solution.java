package advancedgraph.n1584MinCostToConnectAllPoints;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

  public int minCostConnectPoints(int[][] points) {
    Set<Integer> nodesToProcess = new HashSet<>(points.length);
    for (int node = 1; node < points.length; node++) {
      nodesToProcess.add(node);
    }
    int minWeight = 0;
    int curNode = 0;
    PriorityQueue<int[]> primQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    while (!nodesToProcess.isEmpty()) {

      for (int node : nodesToProcess) {
        int distance = calcDistance(points[curNode], points[node]);
        primQueue.offer(new int[]{node, distance});
      }
      int[] nextCurNode = primQueue.poll();
      while (!nodesToProcess.contains(nextCurNode[0]) && !primQueue.isEmpty()) {
        nextCurNode = primQueue.poll();
      }

      minWeight += nextCurNode[1];
      curNode = nextCurNode[0];
      nodesToProcess.remove(curNode);

    }
    return minWeight;
  }

  private int calcDistance(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }
}
