package backtracking.n39CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combinations = new LinkedList<>();
    backtrack(combinations, new LinkedList<>(), Arrays.stream(candidates).boxed().toList(), target,
        0);
    return combinations;
  }

  void backtrack(List<List<Integer>> result, List<Integer> variant, List<Integer> candidates,
      int targetRest, int start) {
    if (targetRest < 0) {
      return;
    }
    if (targetRest == 0) {
      result.add(new ArrayList<>(variant));
      return;
    }

    for (int i = start; i < candidates.size(); i++) {
      int candidate = candidates.get(i);
      variant.add(candidate);
      backtrack(result, variant, candidates, targetRest - candidate,
          i); // not i + 1 because we can reuse same elements
      variant.remove(variant.size() - 1);

    }

  }
}
