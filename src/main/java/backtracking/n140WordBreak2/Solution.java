package backtracking.n140WordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

  public List<String> wordBreak(String s, List<String> wordDict) {
    return new ArrayList<>(backtrack(s, wordDict, new StringBuilder(), new HashMap<>()));
  }

  private Set<String> backtrack(String s, List<String> wordDict, StringBuilder combination,
      Map<String, Set<String>> memo) {
    if (s.isEmpty()) {
      return Set.of(combination.toString());
    }

    if (memo.containsKey(s)) {
      return memo.get(s);
    }

    int length = combination.length();
    Set<String> sentences = new HashSet<>();
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        combination.append(word);
        String subString = s.substring(word.length(), s.length());
        if (!subString.isEmpty()) {
          combination.append(" ");
        }
        sentences.addAll(backtrack(subString, wordDict, combination, memo));
        combination.delete(length, length + word.length() + 1);
      }
    }

    memo.put(combination.toString(), sentences);

    return sentences;
  }
}
