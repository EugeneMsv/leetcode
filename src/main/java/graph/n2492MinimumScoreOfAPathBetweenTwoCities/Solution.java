package graph.n2492MinimumScoreOfAPathBetweenTwoCities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int minScore(int n, int[][] roads) {
    Map<Integer, List<Node>> graph = new HashMap<>();

    for (int[] road : roads) {
      graph.computeIfAbsent(road[0], k -> new LinkedList<>())
          .add(new Node(road[1], road[2]));
      graph.computeIfAbsent(road[1], k -> new LinkedList<>())
          .add(new Node(road[0], road[2]));
    }
    Set<Integer> visited = new HashSet<>();
    Queue<Node> bfs = new LinkedList<>();
    bfs.offer(new Node(1, Integer.MAX_VALUE));

    int min = Integer.MAX_VALUE;

    while (!bfs.isEmpty()) {
      int size = bfs.size();
      for (int i = 0; i < size; i++) {
        Node node = bfs.poll();
        min = Math.min(min, node.distance);
        visited.add(node.city);

        for (Node adjNode : graph.getOrDefault(node.city, List.of())) {
          if (visited.contains(adjNode.city)) {
            continue;
          }
          bfs.offer(adjNode);

        }
      }

    }
    return min;
  }

  static class Node {

    int city;
    int distance;

    Node(int city, int distance) {
      this.city = city;
      this.distance = distance;
    }

    public String toString() {
      return "city=%s, distance=%s".formatted(city, distance);
    }
  }
}