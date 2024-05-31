package advancedgraph.n787CheapestFlightsWithinKStops;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> graph = new HashMap<>();

    for (int[] flight : flights) {
      graph.computeIfAbsent(flight[0], key -> new LinkedList<>())
          .add(new int[]{flight[1], flight[2]});
    }

    Map<Integer, Integer> minPricesFromSrc = new HashMap<>();
    minPricesFromSrc.put(src, 0);

    Queue<int[]> bfs = new LinkedList<>();
    bfs.offer(new int[]{src, 0});

    int stopsLeft = k;
    while (!bfs.isEmpty() && stopsLeft >= 0) {
      int size = bfs.size();

      for (int i = 0; i < size; i++) {
        int[] nodeData = bfs.poll();
        int node = nodeData[0];
        int price = nodeData[1];
        for (int[] neighbour : graph.getOrDefault(node, List.of())) {
          int neighbourPrice = neighbour[1] + price;
          int neighbourNode = neighbour[0];
          Integer curMinNeigbourPrice = minPricesFromSrc.get(neighbourNode);
          if (curMinNeigbourPrice == null || neighbourPrice < curMinNeigbourPrice) {
            minPricesFromSrc.put(neighbourNode, neighbourPrice);
            bfs.offer(new int[]{neighbourNode, neighbourPrice});
          }

        }

      }
      stopsLeft--;
    }

    return minPricesFromSrc.getOrDefault(dst, -1);
  }
}