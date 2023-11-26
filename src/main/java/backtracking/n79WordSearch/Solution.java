package backtracking.n79WordSearch;

public class Solution {

  public boolean exist(char[][] board, String word) {

    char[] letters = word.toCharArray();
    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        char boardChar = board[row][column];
        boolean exists = backtrack(row, column, board, letters, 0);
        if (exists) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean backtrack(
      int lastRow,
      int lastColumn,
      char[][] board,
      char[] word,
      int position) {
    // If it was the last letter
    if (position == word.length) {
      return true;
    }

    if (position >= word.length
        || lastRow < 0 || lastRow >= board.length
        || lastColumn < 0 || lastColumn >= board[lastRow].length) {
      return false;

    }
    char boardChar = board[lastRow][lastColumn];
    // if Already used
    if (boardChar == '$') {
      return false;
    }

    // If not equals to the next letter
    if (boardChar != word[position]) {
      return false;
    }

    // Mark as used
    board[lastRow][lastColumn] = '$';

    boolean exists = backtrack(lastRow + 1, lastColumn, board, word, position + 1)
        || backtrack(lastRow - 1, lastColumn, board, word, position + 1)
        || backtrack(lastRow, lastColumn + 1, board, word, position + 1)
        || backtrack(lastRow, lastColumn - 1, board, word, position + 1);

    if (exists) {
      return true;
    }

    board[lastRow][lastColumn] = boardChar;
    return false;

  }

  void print(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        char boardChar = board[row][column];
        System.out.print(boardChar);
      }
      System.out.println();
    }
    System.out.println("---------------------------------");
  }

}
