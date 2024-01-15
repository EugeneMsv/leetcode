package dynamic.n139WordBreak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public boolean wordBreak(String s, List<String> wordDict) {
    return dp(s, wordDict, new HashMap<>());
  }

  private boolean dp(String s, List<String> dict, Map<String, Boolean> memo) {
    if (s.isEmpty()) {
      return true;
    }
    if (memo.containsKey(s)) {
      return memo.get(s);
    }

    for (String word : dict) {
      if (s.startsWith(word)) {
        boolean result = dp(s.substring(word.length(), s.length()), dict, memo);
        if (result) {
          memo.put(s, true);
          return true;
        }
      }
    }
    memo.put(s, false);
    return false;
  }
}