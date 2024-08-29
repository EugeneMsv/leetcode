package hashing.n3265CountAlmostEqualPairs1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public int countPairs(int[] nums) {

    Map<Integer, Integer> dict = new HashMap<>();

    Map<Integer, Set<Integer>> visited = new HashMap<>();

    for (int num : nums) {
      dict.put(num, dict.getOrDefault(num, 0) + 1);
    }

    int overall = 0;
    for (int num : dict.keySet()) {

      int digitsCount = digitsCount(num);
      int numCount = dict.getOrDefault(num, 1);

      int localResult = numCount >= 2 ? nChooseK(numCount, 2) : 0;
      for (int i = 0; i < digitsCount - 1; i++) {
        for (int j = i + 1; j < digitsCount; j++) {
          int almostEqual = swapDigits(num, i, j);
          if (num == almostEqual || visited.getOrDefault(almostEqual, Set.of()).contains(num)) {
            continue;
          }
          int almostEqualCount = dict.getOrDefault(almostEqual, 0);
          visited.computeIfAbsent(num, k -> new HashSet<>()).add(almostEqual);
          localResult += numCount * almostEqualCount;
        }
      }

      int zeroCase = specialZeroCase(num);
      if (num == zeroCase || visited.getOrDefault(zeroCase, Set.of()).contains(num)) {
        overall += localResult;
        continue;
      }
      int almostEqualCount = dict.getOrDefault(zeroCase, 0);
      visited.computeIfAbsent(num, k -> new HashSet<>()).add(zeroCase);
      localResult += numCount * almostEqualCount;
      overall += localResult;
    }

    return overall;

  }

  public int nChooseK(int n, int k) {
    if (k < 0 || k > n) {
      return 0;
    }
    if (n == k) {
      return 1;
    }
    int result = 1;
    for (int i = 1; i <= k; i++) {
      result *= n - k + i;
      result /= i;
    }
    return result;
  }

  private int specialZeroCase(int num) {
    String bag = String.valueOf(num);
    String bagBegin = bag.substring(0, 1);
    String bagEnd = bag.substring(1);
    return Integer.parseInt(bagBegin + "0" + bagEnd);
  }

  private int digitsCount(int num) {
    return String.valueOf(num).length();
  }

  private int swapDigits(int num, int position1, int position2) {
    char[] chars = String.valueOf(num).toCharArray();
    char temp = chars[position1];
    chars[position1] = chars[position2];
    chars[position2] = temp;
    return Integer.parseInt(new String(chars));
  }
}
