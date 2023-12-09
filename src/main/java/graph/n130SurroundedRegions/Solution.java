package graph.n130SurroundedRegions;

public class Solution {

  public void solve(char[][] board) {
    boolean[][] nonCovertables = new boolean[board.length][board[0].length];
    // First and last row
    for (int j = 0; j < board[0].length; j++) {
      if (board[0][j] == 'O') {
        markNonCovertable(board, 0, j, nonCovertables);
      }
      if (board[board.length - 1][j] == 'O') {
        markNonCovertable(board, board.length - 1, j, nonCovertables);
      }
    }

    // First and last column
    for (int i = 0; i < board.length; i++) {
      if (board[i][0] == 'O') {
        markNonCovertable(board, i, 0, nonCovertables);
      }
      if (board[i][board[0].length - 1] == 'O') {
        markNonCovertable(board, i, board[0].length - 1, nonCovertables);
      }
    }

    // Convert all that eliglible
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        // System.out.print(nonCovertables[i][j]+" ");
        if (board[i][j] == 'O' && !nonCovertables[i][j]) {
          board[i][j] = 'X';
        }
      }
      // System.out.println();
    }

  }

  void markNonCovertable(char[][] board, int i, int j, boolean[][] nonCovertables) {
    if (i < 0 || j < 0
        || i >= board.length
        || j >= board[i].length) {
      return;
    }
    if (nonCovertables[i][j]) {
      return;
    }
    if (board[i][j] == 'X') {
      return;
    }

    nonCovertables[i][j] = true;

    markNonCovertable(board, i + 1, j, nonCovertables);
    markNonCovertable(board, i - 1, j, nonCovertables);
    markNonCovertable(board, i, j + 1, nonCovertables);
    markNonCovertable(board, i, j - 1, nonCovertables);
  }

}
