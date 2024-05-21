package graph.n851LoudAndRich;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    Map<Integer, Set<Integer>> graph = new HashMap<>(n, 1.1F);

    for (int[] rich : richer) {
      Set<Integer> richerNodes = graph.getOrDefault(rich[1], new HashSet<>());
      richerNodes.add(rich[0]);
      graph.put(rich[1], richerNodes);
    }

    int[] answer = new int[n];
    Arrays.fill(answer, -1);
    for (int node = 0; node < n; node++) {
      if (answer[node] < 0) {
        dfs(graph, node, answer, quiet);
      }
    }

    return answer;
  }

  private int dfs(Map<Integer, Set<Integer>> graph, int node, int[] memo, int[] quiet) {
    if (memo[node] >= 0) {
      return memo[node];
    }

    Set<Integer> richerNodes = graph.getOrDefault(node, Set.of());

    int minQuietNode = node;
    for (int richerNode : richerNodes) {
      int minQuietNodeCandidate = dfs(graph, richerNode, memo, quiet);
      if (quiet[minQuietNodeCandidate] < quiet[minQuietNode]) {
        minQuietNode = minQuietNodeCandidate;
      }
    }

    memo[node] = minQuietNode;
    return minQuietNode;

  }
}
