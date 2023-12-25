package graph.n695MaxIslandArea;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int maxSquare = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          visited[i][j] = true;
          maxSquare = Math.max(maxSquare, bfs(visited, grid, i, j));
        }
      }
    }
    return maxSquare;
  }

  private int bfs(boolean[][] visited, int[][] grid, int i, int j) {
    Queue<Node> nodes = new LinkedList<>();
    nodes.offer(new Node(i, j));
    int square = 0;
    while (!nodes.isEmpty()) {
      Node node = nodes.poll();
      square++;
      tryAdd(node.x + 1, node.y, nodes, grid, visited);
      tryAdd(node.x - 1, node.y, nodes, grid, visited);
      tryAdd(node.x, node.y + 1, nodes, grid, visited);
      tryAdd(node.x, node.y - 1, nodes, grid, visited);

    }
    return square;
  }

  private void tryAdd(int i, int j, Queue<Node> nodes, int[][] grid, boolean[][] visited) {
    if (i < 0 || j < 0
        || i >= grid.length || j >= grid[i].length) {
      return;
    }

    if (!visited[i][j] && grid[i][j] == 1) {
      nodes.offer(new Node(i, j));
      visited[i][j] = true;
    }
  }

  private class Node {

    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}