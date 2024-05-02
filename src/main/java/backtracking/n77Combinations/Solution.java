package backtracking.n77Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new LinkedList<>();

    backtrack(result, new ArrayList<>(k), 1, k, n);

    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> combination, int start, int left,
      int n) {
    if (left == 0) {
      result.add(List.copyOf(combination));
      return;
    }

    for (int i = start; i <= n; i++) {
      combination.add(i);
      backtrack(result, combination, i + 1, left - 1, n);
      combination.remove(combination.size() - 1);
    }
  }
}
