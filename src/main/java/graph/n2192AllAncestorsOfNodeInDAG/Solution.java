package graph.n2192AllAncestorsOfNodeInDAG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<List<Integer>> getAncestors(int n, int[][] edges) {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }

    Queue<Integer> queue = new LinkedList<>();

    List<List<Integer>> result = new LinkedList<>();

    for (int node = 0; node < n; node++) {
      // BFS for each node
      queue.offer(node);
      List<Integer> ancestors = new ArrayList<>();
      boolean[] visited = new boolean[n];
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int ancestor = queue.poll();
          if (ancestor != node) {
            ancestors.add(ancestor);
          }
          for (int subAncestor : graph.getOrDefault(ancestor, Set.of())) {
            if (!visited[subAncestor]) {
              queue.offer(subAncestor);
              visited[subAncestor] = true;
            }

          }

        }
      }

      Collections.sort(ancestors);
      result.add(ancestors);
    }

    return result;
  }
}