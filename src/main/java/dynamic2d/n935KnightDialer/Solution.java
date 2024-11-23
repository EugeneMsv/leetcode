package dynamic2d.n935KnightDialer;

import java.util.HashMap;
import java.util.Map;

class Solution {

  static int[][] moves = new int[][]{
      new int[]{4, 6}, //0
      new int[]{8, 6}, //1
      new int[]{7, 9}, //2
      new int[]{4, 8}, //3
      new int[]{0, 3, 9}, //4
      new int[]{}, //5
      new int[]{1, 7, 0}, //6
      new int[]{6, 2}, //7
      new int[]{1, 3}, //8
      new int[]{2, 4}, //9
  };

  public int knightDialer(int n) {
    Map<String, Integer> cache = new HashMap<>();

    int sum = 0;
    for (int i = 0; i <= 9; i++) {
      sum += dp(cache, i, n);
      sum = sum % 1_000_000_007;
    }
    System.out.println(sum);
    return sum;
  }

  private int dp(Map<String, Integer> cache, int start, int n) {
    if (n == 1) {
      return 1;
    }
    String key = start + ";" + n;
    Integer result = cache.get(key);
    if (result != null) {
      return result;
    }

    result = 0;
    for (int nextStart : moves[start]) {
      result += dp(cache, nextStart, n - 1);
      result = result % 1_000_000_007;
    }

    cache.put(key, result);
    return result;
  }
}