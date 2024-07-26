package trie.n648ReplaceWords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

  public String replaceWords(List<String> dictionary, String sentence) {
    Trie dummy = new Trie();
    for (String root : dictionary) {
      dummy.addWord(root, 0);
    }

    StringBuffer sb = new StringBuffer();

    for (String word : sentence.split(" ")) {
      if (!sb.isEmpty()) {
        sb.append(" ");
      }
      String result = dummy.searchWord(word, 0);
      sb.append(result == null ? word : result);
    }

    return sb.toString();
  }

  static class Trie {

    Set<String> roots = new HashSet();
    Map<Character, Trie> next = new HashMap<>();

    void addWord(String word, int idx) {
      if (idx > word.length()) {
        return;
      }

      if (idx == word.length()) {
        roots.add(word);
        return;
      }

      next.computeIfAbsent(word.charAt(idx), (k) -> new Trie()).addWord(word, idx + 1);
    }

    String searchWord(String word, int idx) {
      if (idx >= word.length()) {
        return null;
      }
      char c = word.charAt(idx);
      Trie trie = next.get(c);
      if (trie == null) {
        return null;
      }
      if (!trie.roots.isEmpty()) {
        return trie.roots.iterator().next();
      }

      return trie.searchWord(word, idx + 1);
    }

  }
}
