package trie.n1268SearchSuggestionsSystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie dict = new Trie();
    for (String product : products) {
      dict.addWord(product, 0);
    }

    List<List<String>> result = new LinkedList<>();
    Trie curLevel = dict;
    for (char c : searchWord.toCharArray()) {

      Trie nextLevel = curLevel.get(c);
      result.add(nextLevel == null
          ? List.of()
          : nextLevel.getTop3());

      curLevel = nextLevel == null ? new Trie() : nextLevel;

    }
    return result;
  }

  static class Trie {

    final Set<String> words = new TreeSet<>();
    final Map<Character, Trie> next = new HashMap<>();

    void addWord(final String word, int startIdx) {
      if (startIdx >= word.length()) {
        words.add(word);
        return;
      }

      words.add(word);
      char c = word.charAt(startIdx);
      next.computeIfAbsent(c, k -> new Trie()).addWord(word, startIdx + 1);
    }

    Trie get(Character c) {
      return next.get(c);
    }

    List<String> getTop3() {
      int count = 1;
      Iterator<String> iterator = words.iterator();
      List<String> result = new LinkedList<>();
      while (count <= 3 && iterator.hasNext()) {
        result.add(iterator.next());
        count++;
      }
      return result;
    }
  }
}
