package array.n1502CanMakeArithmeticProgressionFromSequence;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public boolean canMakeArithmeticProgression(int[] nums) {
    if (nums.length <= 2) {
      return true;
    }
    int min = Integer.MAX_VALUE;
    Integer prevMin = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num < prevMin && num > min) {
        prevMin = num;
      }
      if (num < min) {
        prevMin = min;
        min = num;
      }

    }
    if (prevMin == Integer.MAX_VALUE) {
      return true;
    }

    Map<Integer, Integer> expected = new HashMap<>();
    int step = prevMin - min;
    int prev = min;

    for (int i = 1; i <= nums.length; i++) {
      expected.put(prev, 0);
      prev += step;
    }

    for (int num : nums) {
      if (!expected.containsKey(num)) {
        return false;
      }
      Integer matches = expected.get(num);
      if (matches >= 1) {
        return false;
      }
      expected.put(num, matches + 1);
    }
    return true;
  }
}
