package graph.n1466ReorderRoutesToMakeAllPathsLeadToTheCityZero;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

  static int toChange;

  public int minReorder(int n, int[][] connections) {
    toChange = 0;
    Map<Integer, List<Edge>> graph = new HashMap<>();

    for (int[] originalEdge : connections) {
      graph.computeIfAbsent(originalEdge[0], k -> new LinkedList<>())
          .add(new Edge(originalEdge[1], true));
      graph.computeIfAbsent(originalEdge[1], k -> new LinkedList<>())
          .add(new Edge(originalEdge[0], false));
    }

    System.out.println(graph);
    boolean[] visited = new boolean[n];

    for (int node = 1; node < n; node++) {
      if (!visited[node]) {
        dfs(graph, 0, node, -1, visited);
      }
      // visited[0] =false;
    }
    return toChange;
  }

  private void dfs(Map<Integer, List<Edge>> graph, Integer node, Integer target, Integer parent,
      boolean[] visited) {
    if (node == target) {
      return;
    }

    for (Edge edge : graph.getOrDefault(node, List.of())) {

      if (edge.to == parent) {
        continue;
      }

      if (!visited[node] && edge.original) {
        // System.out.println("Changing edge %s->%s".formatted(edge.to, node));
        toChange++;
      }
      dfs(graph, edge.to, target, node, visited);
    }
    visited[node] = true;
  }

  static class Edge {

    int to;
    boolean original;

    Edge(
        int to,
        boolean original) {
      this.to = to;
      this.original = original;
    }

    public String toString() {
      return "{to=%s, original=%s}".formatted(to, original);
    }

  }
}