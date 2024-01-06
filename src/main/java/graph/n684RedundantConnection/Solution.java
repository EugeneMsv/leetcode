package graph.n684RedundantConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

  boolean[] visited;

  public int[] findRedundantConnection(int[][] edges) {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < edges.length; i++) {
      hashMap.put(i + 1, new ArrayList<>());
    }

    int[] res = new int[2];
        /*
        Since the question require us to remove the redundant edge, when we constructing the graph, we do dfs on each edge to see is it redundant, if yes return the edge, if no add the edge into the graph.
        */
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      visited = new boolean[edges.length + 1];
      if (!hashMap.get(edge[0]).isEmpty() && !hashMap.get(edge[1]).isEmpty() && dfs(edge[0],
          edge[1], hashMap)) {
        return edge;
      }
      hashMap.get(edge[0]).add(edge[1]);
      hashMap.get(edge[1]).add(edge[0]);
    }
    return res;
  }

  public boolean dfs(int src, int target, HashMap<Integer, List<Integer>> hashMap) {
    if (src == target) {
      return true;
    }
    visited[src] = true;
    List<Integer> edgeList = hashMap.get(src);

    for (Integer next : edgeList) {
      if (!visited[next]) {
        if (dfs(next, target, hashMap)) {
          return true;
        }
      }
    }

    return false;
  }
}
