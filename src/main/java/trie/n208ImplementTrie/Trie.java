package trie.n208ImplementTrie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

  private final TrieLevel root = new TrieLevel();

  public Trie() {

  }

  public void insert(String word) {

    TrieLevel current = root;
    for (Character symbol : word.toCharArray()) {
      TrieLevel next = current.map.get(symbol);
      if (next == null) {
        next = new TrieLevel();
        current.map.put(symbol, next);
      }
      current = next;
    }
    current.fullWord = true;

  }

  public boolean search(String word) {

    TrieLevel current = root;

    for (Character symbol : word.toCharArray()) {

      TrieLevel next = current.map.get(symbol);
      if (next == null) {
        return false;
      }
      current = next;
    }
    return current.fullWord;
  }

  public boolean startsWith(String prefix) {

    TrieLevel current = root;

    for (Character symbol : prefix.toCharArray()) {
      TrieLevel next = current.map.get(symbol);
      if (next == null) {
        return false;
      }
      current = next;
    }
    return true;
  }

  private static class TrieLevel {

    private boolean fullWord;
    private final Map<Character, TrieLevel> map = new HashMap<Character, TrieLevel>(22, 1.1F);

    public TrieLevel() {
    }

  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
