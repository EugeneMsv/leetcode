package graph.n909SnakesLadders;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private static int n;

  public int snakesAndLadders(int[][] board) {
    n = board.length;

    Queue<Integer> bfs = new LinkedList<>();
    bfs.offer(1);

    int minMoves = Integer.MAX_VALUE;
    int moves = 0;

    boolean[] visited = new boolean[n * n + 1];

    // Each iteration are all possible positions for the next move
    while (!bfs.isEmpty()) {

      int size = bfs.size();

      for (int j = 0; j < size; j++) {
        // Checking one of possible positions for this move
        int curr = bfs.poll();

        // If we are in the end, then try record moves as min
        if (curr == n * n) {
          minMoves = Math.min(minMoves, moves);
          continue;
        }

        // Calculate all possible next positions for current one
        for (int i = curr + 1; i <= Math.min(curr + 6, n * n); i++) {

          int jumpTo = board[row(i)][column(i)];
          int next = jumpTo > 0 ? jumpTo : i;
          // Skipping next position if visited before
          if (visited[next]) {
            continue;
          }
          bfs.offer(next);
          visited[next] = true;

        }
      }
      moves++;

    }
    return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
  }

  private int row(int curr) {
    int row = n - 1 - (curr - 1) / n;
    return row;
  }

  private int column(int curr) {
    int row = row(curr);
    int column = -1;
    if ((n - row) % 2 != 0) {
      column = (curr - 1) % n;
    } else {
      column = n - 1 - (curr - 1) % n;
    }

    return column;
  }
}
