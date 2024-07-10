package backtracking.n216CombinationSum3;

import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new LinkedList<>();
    backtrace(result, new LinkedList<>(), 1, n, k);
    return result;
  }

  private void backtrace(List<List<Integer>> combinations, List<Integer> candidate, int start,
      int n, int k) {
    if (candidate.size() > k) {
      return;
    }

    if (candidate.size() == k) {
     if (n == 0) {
      combinations.add(List.copyOf(candidate));
     }
      return;
    }

    if (n < 0) {
      return;
    }

    for (int num = start; num <= 9; num++) {
      candidate.add(num);
      backtrace(combinations, candidate, num + 1, n - num, k);
      candidate.remove(candidate.size() - 1);
    }
  }
}
