package backtracking.n40CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new LinkedList<>();
    Arrays.sort(candidates);
    backtrack(result, new LinkedList<>(), candidates, target, 0);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> variant, int[] nums, int target,
      int start) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(variant));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (i > start && i >= 1 && nums[i] == nums[i - 1]) {
        continue;
      }
      int num = nums[i];
      variant.add(num);

      backtrack(result, variant, nums, target - num, i + 1);
      variant.remove(variant.size() - 1);
    }
  }
}
