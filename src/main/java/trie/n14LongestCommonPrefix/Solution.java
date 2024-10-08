package trie.n14LongestCommonPrefix;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public String longestCommonPrefix(String[] strs) {
    Trie trie = new Trie();

    for (String word : strs) {
      trie.add(word, 0);
    }
    int n = strs.length;

    return trie.search(new StringBuilder(), n);

  }

  class Trie {

    int count;
    Map<Character, Trie> next = new HashMap<>();

    public void add(String word, int idx) {
      count++;
      if (idx >= word.length()) {
        return;
      }

      Character c = word.charAt(idx);

      next.computeIfAbsent(c, k -> new Trie())
          .add(word, idx + 1);
    }

    public String search(StringBuilder sb, int targetCount) {
      String longestPrefix = sb.toString();
      for (Map.Entry<Character, Trie> entry : next.entrySet()) {
        Trie trie = entry.getValue();
        if (trie.count != targetCount) {
          continue;
        }
        sb.append(entry.getKey());
        String cycleResult = trie.search(sb, targetCount);
        sb.setLength(sb.length() - 1);
        if (cycleResult.length() > longestPrefix.length()) {
          longestPrefix = cycleResult;
        }
      }

      return longestPrefix;
    }
  }
}