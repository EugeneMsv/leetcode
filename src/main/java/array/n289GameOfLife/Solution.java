package array.n289GameOfLife;

public class Solution {

  public void gameOfLife(int[][] board) {

    for (int i = 0; i < board.length; i++) {

      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = calcNewValue(i, j, board);
      }
    }

    for (int i = 0; i < board.length; i++) {

      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = getNewValue(board[i][j]);
      }
    }

  }

  private int calcNewValue(int i, int j, int[][] board) {
    int liveNeighbors = 0;
    liveNeighbors += calcLive(i - 1, j - 1, board);
    liveNeighbors += calcLive(i - 1, j, board);
    liveNeighbors += calcLive(i - 1, j + 1, board);
    liveNeighbors += calcLive(i, j - 1, board);
    liveNeighbors += calcLive(i, j + 1, board);
    liveNeighbors += calcLive(i + 1, j - 1, board);
    liveNeighbors += calcLive(i + 1, j, board);
    liveNeighbors += calcLive(i + 1, j + 1, board);
    int currentValue = getOldValue(board[i][j]);
    int newValue = 0;

    if (currentValue == 0) {
      // Was dead
      newValue = liveNeighbors == 3 ? 1 : 0;
    } else {
      // Was alive
      newValue = liveNeighbors == 2 || liveNeighbors == 3 ? 1 : 0;
    }
    return converToNew(newValue, currentValue);
  }

  private int calcLive(int i, int j, int[][] board) {
    if (i < 0 || i >= board.length
        || j < 0 || j >= board[i].length) {
      return 0;
    }

    return getOldValue(board[i][j]);
  }

  private int converToNew(int newValue, int oldValue) {
    return 100 + 10 * newValue + oldValue;
  }

  private int getOldValue(int value) {
    return value % 10;
  }

  private int getNewValue(int value) {
    return value % 100 / 10;
  }
}
