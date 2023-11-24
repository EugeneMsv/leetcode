package backtracking.n90Subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    backtrack(result, new ArrayList(nums.length), Arrays.stream(nums).sorted().boxed().collect(
        Collectors.toList()));
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> variant, List<Integer> nums) {
    result.add(new ArrayList<>(variant));

    for (int i = 0; i < nums.size(); i++) {
      Integer num = nums.get(i);
      if (i > 0 && nums.get(i - 1).equals(num)) { // skip duplicates
        continue;
      }

      variant.add(num);
      backtrack(result, variant, nums.subList(i + 1, nums.size()));
      variant.remove(variant.size() - 1);
    }
  }
}
