package graph.n417PacificAtlanticWaterFlow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolution {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    boolean[][] pacific = new boolean[heights.length][heights[0].length];
    boolean[][] atlantic = new boolean[heights.length][heights[0].length];

    for (int j = 0; j < heights[0].length; j++) {
      bfs(pacific, heights, 0, j);
      bfs(atlantic, heights, heights.length - 1, j);
    }

    for (int i = 0; i < heights.length; i++) {
      bfs(pacific, heights, i, 0);
      bfs(atlantic, heights, i, heights[0].length - 1);
    }

    List<List<Integer>> bothOceans = new LinkedList<>();

    for (int i = 0; i < heights.length; i++) {
      for (int j = 0; j < heights[i].length; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          bothOceans.add(List.of(i, j));
        }
      }
    }
    return bothOceans;
  }

  private void bfs(boolean[][] visited, int[][] heights, int i, int j) {
    if (visited[i][j]) {
      return;
    }

    Queue<int[]> nodes = new LinkedList<>();
    nodes.offer(new int[]{i, j});
    while (!nodes.isEmpty()) {
      int[] node = nodes.poll();
      int x = node[0];
      int y = node[1];
      if (visited[x][y]) {
        continue;
      }
      visited[x][y] = true;

      addNeighbour(visited, nodes, heights, x - 1, y, heights[x][y]);
      addNeighbour(visited, nodes, heights, x + 1, y, heights[x][y]);
      addNeighbour(visited, nodes, heights, x, y - 1, heights[x][y]);
      addNeighbour(visited, nodes, heights, x, y + 1, heights[x][y]);
    }
  }

  private void addNeighbour(boolean[][] visited, Queue<int[]> nodes, int[][] heights, int x, int y,
      int parentHeight) {
    if (x < 0 || y < 0
        || x >= heights.length
        || y >= heights[x].length) {
      return;
    }

    if (visited[x][y]) {
      return;
    }

    if (parentHeight > heights[x][y]) {
      return;
    }
    nodes.offer(new int[]{x, y});
  }

}
