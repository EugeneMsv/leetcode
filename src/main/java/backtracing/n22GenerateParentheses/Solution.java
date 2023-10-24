package backtracing.n22GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<String> generateParenthesis(int n) {
    List<String> validCombinations = new LinkedList<String>();
    backTrack(validCombinations, "(", 2 * n - 1);
    return validCombinations;
  }

  private void backTrack(List<String> validCombinations, String nextCombination, int depth) {
    if (depth <= 0) {
      if (isValid(nextCombination)) {
        validCombinations.add(nextCombination);
      }

      return;
    }
    backTrack(validCombinations, nextCombination + "(", depth - 1);
    backTrack(validCombinations, nextCombination + ")", depth - 1);
  }

  // We can do more effective without even checking the validity in that way
  private boolean isValid(String combination) {
    int size = 0;
    for (int i = 0; i < combination.length(); i++) {
      if (combination.charAt(i) == '(') {
        size++;
      } else {
        size--;
      }
      if (size < 0) {
        return false;
      }
    }
    return size == 0;
  }

}
