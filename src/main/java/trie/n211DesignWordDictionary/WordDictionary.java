package trie.n211DesignWordDictionary;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

  private TrieLevel root = new TrieLevel();

  public WordDictionary() {

  }

  public void addWord(String word) {
    TrieLevel current = root;
    for (Character symbol : word.toCharArray()) {
      TrieLevel node = current.next.get(symbol);
      if (node == null) {
        node = new TrieLevel();
        current.next.put(symbol, node);
      }
      current = node;
    }
    current.fullWord = true;
  }

  public boolean search(String word) {
    return search(word.toCharArray(), 0, root);
  }

  private boolean search(char[] word, int from, TrieLevel start) {
    TrieLevel current = start;

    for (int idx = from; idx < word.length; idx++) {
      Character symbol = word[idx];
      if (symbol.equals('.')) {

        boolean fullWord = false;
        for (TrieLevel level : current.next.values()) {
          fullWord |= level.fullWord;
          if (search(word, idx + 1, level)) {
            return true;
          }
        }

        return fullWord && idx + 1 == word.length;
      } else {

        TrieLevel node = current.next.get(symbol);
        if (node == null) {
          return false;
        }
        current = node;
      }
    }
    return current.fullWord;
  }

  private static class TrieLevel {

    private boolean fullWord;
    private final Map<Character, TrieLevel> next = new HashMap<>(6, 1.0F);
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new
 * WordDictionary(); obj.addWord(word); boolean param_2 = obj.search(word);
 */
