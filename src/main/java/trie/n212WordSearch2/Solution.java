package trie.n212WordSearch2;

import java.util.*;

class Solution {

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    Trie root = new Trie();
    for (String word : words) {
      root.insertWord(word); // Build Trie using recursive insertion
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, res);
      }
    }
    return res;
  }

  private void dfs(char[][] board, int i, int j, Trie p, List<String> res) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#'
        || !p.next.containsKey(board[i][j])) {
      return; // Out of bounds, cell visited, or character not in Trie
    }

    char c = board[i][j]; // Store current character
    p = p.next.get(c); // Move to the child node corresponding to the character

    if (p.wrd != null) { // Check if the current node contains a complete word
      res.add(p.wrd); // Add the word to the result list
      p.wrd = null; // Mark as visited to avoid adding the word again
    }

    board[i][j] = '#'; // Mark cell as visited
    dfs(board, i - 1, j, p, res); // Explore all 4 directions
    dfs(board, i + 1, j, p, res);
    dfs(board, i, j - 1, p, res);
    dfs(board, i, j + 1, p, res);
    board[i][j] = c; // Restore cell value after backtracking
  }

  // Trie class with Map-based children
  class Trie {

    Map<Character, Trie> next = new HashMap<>(); // Map to store child nodes
    String wrd; // Store the word at the end of the path

    // Recursive method to insert a word into the Trie
    void insertWord(String word) {
      insertWord(word, 0);
    }

    // Recursive helper method to insert a word into the Trie
    private void insertWord(String word, int index) {
      if (index == word.length()) {
        this.wrd = word; // Set the end of the word
        return;
      }

      char c = word.charAt(index);
      if (!next.containsKey(c)) {
        next.put(c, new Trie()); // Create a new node if necessary
      }
      next.get(c).insertWord(word, index + 1); // Recur for the next character
    }
  }
}

