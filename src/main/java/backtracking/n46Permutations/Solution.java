package backtracking.n46Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> permutations = new LinkedList<>();
    backtrack(permutations, new ArrayList<>(nums.length),
        Arrays.stream(nums).boxed().collect(Collectors.toList()));
    return permutations;

  }

  private void backtrack(List<List<Integer>> permutations, List<Integer> variant,
      List<Integer> nums) {
    if (variant.size() == nums.size()) {
      permutations.add(new ArrayList<>(variant));
      return;
    }

    for (int i = 0; i < nums.size(); i++) {
      Integer num = nums.get(i);
      if (num == Integer.MIN_VALUE) {
        continue;
      }
      variant.add(num);

      nums.set(i, Integer.MIN_VALUE); // to skip processing of the current num in downstream
      backtrack(permutations, variant, nums);
      nums.set(i, num);  // return it back

      variant.remove(variant.size() - 1);
    }

  }
}
