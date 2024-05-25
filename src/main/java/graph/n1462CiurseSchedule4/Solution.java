package graph.n1462CiurseSchedule4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    int[] degree = new int[n];
    for (int[] edge : prerequisites) {
      graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      degree[edge[1]] += 1;
    }

    Queue<Integer> q = new LinkedList<>();

    for (int node = 0; node < degree.length; node++) {
      if (degree[node] == 0) {
        q.offer(node);
      }
    }

    Map<Integer, Set<Integer>> prevs = new HashMap<>();

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int node = q.poll();

        for (Integer nextNode : graph.getOrDefault(node, Set.of())) {
          Set<Integer> preReq = prevs.computeIfAbsent(nextNode, k -> new HashSet<>());
          preReq.add(node);
          preReq.addAll(prevs.getOrDefault(node, Set.of()));

          degree[nextNode] -= 1;

          if (degree[nextNode] == 0) {
            q.offer(nextNode);
          }
        }
      }
    }

    List<Boolean> answer = new ArrayList<>(queries.length);

    for (int[] query : queries) {
      answer.add(prevs.getOrDefault(query[1], Set.of()).contains(query[0]));
    }

    return answer;
  }
}
