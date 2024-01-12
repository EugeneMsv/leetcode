package dynamic.n91DecodeWays;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numDecodings(String s) {
    return dp(s, s.length() - 1, new HashMap<>());
  }

  private int dp(String s, int end, Map<Integer, Integer> memo) {
    if (end < 0) {
      return 0;
    }
    if (end == 0) {
      return canDecode(s.charAt(0)) ? 1 : 0;
    }

    if (end == 1) {
      boolean first = canDecode(s.charAt(0));
      boolean second = canDecode(s.charAt(1));
      boolean both = canDecode(s.charAt(0), s.charAt(1));
      if (first && second && both) {
        return 2;
      }
      if (first && second) {
        return 1;
      }

      if (both) {
        return 1;
      }
      return 0;
    }
    if (memo.get(end) != null) {
      return memo.get(end);
    }

    int prevWays1 = dp(s, end - 1, memo);
    if (canDecode(s.charAt(end))) {

    } else {
      prevWays1 = 0;
    }

    int prevWays2 = dp(s, end - 2, memo);
    if (end - 1 >= 0 && canDecode(s.charAt(end - 1), s.charAt(end))) {
    } else {
      prevWays2 = 0;
    }

    memo.put(end, prevWays1 + prevWays2);
    return prevWays1 + prevWays2;
  }

  private boolean canDecode(char c) {
    return Integer.parseInt(String.valueOf(c)) != 0;
  }

  private boolean canDecode(char first, char second) {

    int value = Integer.parseInt(String.valueOf(first) + String.valueOf(second));
    return canDecode(first) && value > 0 && value <= 26;
  }

}
