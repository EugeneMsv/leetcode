package graph.n310MinimunHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return List.of(0); // Only one node, return the root
    }

    Map<Integer, Set<Integer>> graph = new HashMap<>(edges.length);
    int[] degrees = new int[n];
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
      degrees[edge[0]]++;
      degrees[edge[1]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (degrees[i] == 1) {
        queue.offer(i);
      }
    }

    int remainingNodes = n;
    while (remainingNodes > 2) {
      int size = queue.size();
      remainingNodes -= size;

      for (int i = 0; i < size; i++) {
        int leaf = queue.poll();
        for (int neighbor : graph.get(leaf)) {
          degrees[neighbor]--;
          if (degrees[neighbor] == 1) {
            queue.offer(neighbor);
          }
        }
        graph.remove(leaf);

      }
    }

    return new ArrayList<>(queue);

  }
}