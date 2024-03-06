package array.n1679MaxNumberOfKSumPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();

    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    int ops = 0;
    for (int num : nums) {
      int firstCount = freq.getOrDefault(num, 0);
      if (firstCount > 0) {
        int target = k - num;
        int secondCount = freq.getOrDefault(target, 0);
        if ((target != num && secondCount > 0) || (target == num && secondCount > 1)) {
          ops++;
          freq.put(num, firstCount - 1);
          freq.put(target, freq.getOrDefault(target, 0) - 1);
        }

      }
    }
    return ops;

  }
}
