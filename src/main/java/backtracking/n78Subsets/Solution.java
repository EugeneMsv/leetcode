package backtracking.n78Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    backtrack(result, new ArrayList<>(nums.length),
        Arrays.stream(nums).boxed().collect(Collectors.toList()));
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> variant, List<Integer> nums) {
    result.add(new ArrayList<>(variant));
    for (int idx = 0; idx < nums.size(); idx++) {
      variant.add(nums.get(idx));
      backtrack(result, variant, nums.subList(idx + 1, nums.size()));
      variant.remove(variant.size() - 1);
    }
  }
}
