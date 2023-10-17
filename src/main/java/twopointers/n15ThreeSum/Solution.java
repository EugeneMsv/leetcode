package twopointers.n15ThreeSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, Set<Integer>> dict = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      Integer num = nums[i];
      Set<Integer> indexes = dict.get(num);
      if (indexes == null) {
        indexes = new LinkedHashSet<>();
        dict.put(num, indexes);
      }
      indexes.add(i);
    }

    Set<Triplet> triplets = new HashSet<>();
    Set<Integer> usedFirst = new HashSet<>();
    int i = 0;
    while (i < nums.length - 2) {

      int first = nums[i];
      if (usedFirst.contains(first)) {
        i++;
        continue;
      }
      usedFirst.add(first);
      int j = i + 1;
      int target = -first;
      while (j < nums.length) {
        int second = nums[j];
        Set<Integer> thirdCandidates = dict.get(target - second);
        if (thirdCandidates != null) {
          for (int k : thirdCandidates) {
            if (k > j) {
              triplets.add(new Triplet(first, second, target - second));
              break;
            }
          }
        }
        j++;
      }
      i++;

    }
    List<List<Integer>> result = new LinkedList<>();
    for (Triplet triplet : triplets) {
      result.add(triplet.toList());
    }
    return result;

  }

  class Triplet {

    int first;
    int second;
    int third;

    public Triplet(int num1, int num2, int num3) {
      this.first = Math.min(num1, Math.min(num2, num3));
      this.third = Math.max(num1, Math.max(num2, num3));
      this.second = 0 - first - third;
    }

    public boolean equals(Object obj) {
      return first == ((Triplet) obj).first && second == ((Triplet) obj).second
          && third == ((Triplet) obj).third;
    }

    public int hashCode() {
      return Objects.hash(first, second, third);
    }

    public List<Integer> toList() {
      return Arrays.asList(first, second, third);
    }

  }
}
