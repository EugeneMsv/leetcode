package array.n36ValidSudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public boolean isValidSudoku(char[][] board) {
    Set<Integer> rowStore = new HashSet<>(9);
    List<Set<Integer>> columns = new ArrayList<>(9);
    for (int i = 1; i <= 9; i++) {
      columns.add(new HashSet<>(9));
    }
    Map<String, Set<Integer>> boxes = new HashMap<>(9);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        boxes.put(i + "" + j, new HashSet<>(9));
      }
    }

    for (int row = 0; row < board.length; row++) {
      rowStore.clear();

      for (int column = 0; column < board[row].length; column++) {
        char rawDigit = board[row][column];
        if (!Character.isDigit(rawDigit)) {
          continue;
        }
        int digit = Character.getNumericValue(rawDigit);
        boolean newToRow = rowStore.add(digit);
        if (!newToRow) {
          return false;
        }

        boolean newToColumn = columns.get(column).add(digit);
        if (!newToColumn) {
          return false;
        }
        String boxKey = row / 3 + "" + column / 3;
        boolean newToBox = boxes.get(boxKey).add(digit);

        if (!newToBox) {
          return false;
        }

      }
    }
    return true;
  }
}
