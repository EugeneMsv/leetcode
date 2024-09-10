package trie.n2707ExtraCharactersInAString;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public int minExtraChar(String s, String[] dictionary) {

    Trie rootTrie = new Trie();

    for (String word : dictionary) {
      rootTrie.add(word, 0);
    }

    int[] dp = new int[s.length()];
    char[] chars = s.toCharArray();
    dp[0] = rootTrie.isWord(chars, 0, 1) ? 0 : 1;

    for (int i = 1; i < chars.length; i++) {
      int min = Integer.MAX_VALUE;
      for (int idx = 0; idx <= i; idx++) {
        int extraCount = rootTrie.isWord(chars, idx, i + 1) ? 0 : i + 1 - idx;
        if (idx > 0) {
          extraCount += dp[idx - 1];
        }
        min = Math.min(min, extraCount);
      }
      dp[i] = min;
    }

    return dp[s.length() - 1];
  }

  class Trie {

    Map<Character, Trie> next = new HashMap<>();
    boolean isWord;

    void add(String word, int idx) {
      if (idx == word.length()) {
        isWord = true;
        return;
      }

      next.computeIfAbsent(word.charAt(idx), k -> new Trie())
          .add(word, idx + 1);
    }

    boolean isWord(char[] chars, int current, int end) {
      if (current >= end) {
        return isWord;
      }

      Trie trie = next.get(chars[current]);
      if (trie == null) {
        return false;
      }
      return trie.isWord(chars, current + 1, end);
    }
  }
}
