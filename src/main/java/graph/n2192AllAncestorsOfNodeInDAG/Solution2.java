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

class Solution2 {

  public List<List<Integer>> getAncestors(int n, int[][] edges) {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int[] degree = new int[n];
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      degree[edge[1]] += 1;
    }

    Queue<Integer> leaves = new LinkedList<>();

    for (int node = 0; node < degree.length; node++) {
      if (degree[node] == 0) {
        leaves.offer(node);
      }
    }

    Map<Integer, Set<Integer>> children = new HashMap<>();

    while (!leaves.isEmpty()) {
      int size = leaves.size();
      for (int i = 0; i < size; i++) {
        int node = leaves.poll();
        for (Integer parent : graph.getOrDefault(node, Set.of())) {
          Set<Integer> allChildren = children.computeIfAbsent(parent, k -> new HashSet<>());
          allChildren.add(node);
          allChildren.addAll(children.getOrDefault(node, Set.of()));

          degree[parent] -= 1;
          if (degree[parent] == 0) {
            leaves.offer(parent);
          }
        }
      }
    }

    List<List<Integer>> result = new ArrayList<>(n);
    for (int node = 0; node < n; node++) {
      List<Integer> nodeAncestors = new ArrayList<>(children.getOrDefault(node, Set.of()));
      Collections.sort(nodeAncestors);
      result.add(nodeAncestors);
    }

    return result;

  }
}
