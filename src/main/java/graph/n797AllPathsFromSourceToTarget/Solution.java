package graph.n797AllPathsFromSourceToTarget;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    List<List<Integer>> paths = new LinkedList<>();

    dfs(paths, new LinkedList<>(), graph, 0);
    return paths;
  }

  private void dfs(List<List<Integer>> paths, List<Integer> candidate, int[][] graph, int node) {
    candidate.add(node);
    if (node == graph.length - 1) {
      paths.add(List.copyOf(candidate));
      return;
    }

    for (int nextNode : graph[node]) {

      dfs(paths, candidate, graph, nextNode);
      candidate.remove(candidate.size() - 1);
    }
  }
}
