package graph.n127WordLadder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    Map<String, Set<String>> graph = new HashMap<>(wordList.size(), 1.1F);
    for (String word : wordList) {
      graph.put(word, new HashSet<>());
    }
    graph.put(beginWord, new HashSet<>());
    if (!graph.containsKey(endWord)) {
      return 0;
    }

    // Buidling the graph
    for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
      String word = entry.getKey();
      char[] chars = word.toCharArray();
      for (int cIdx = 0; cIdx < chars.length; cIdx++) {
        char original = chars[cIdx];

        for (int i = 0; i < 26; i++) {
          char modified = (char) (i + (int) 'a');
          if (modified == original) {
            continue;
          }
          chars[cIdx] = modified;
          String adjacentWord = new String(chars);
          Set<String> adjacentWords = graph.get(adjacentWord);
          if (adjacentWords != null) {
            adjacentWords.add(word);
            entry.getValue().add(adjacentWord);
          }
          chars[cIdx] = original;
        }
      }

    }

    // BFS
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    int step = 1;
    Set<String> visited = new HashSet<>();

    while (!q.isEmpty()) {

      int size = q.size();

      for (int i = 0; i < size; i++) {
        String word = q.poll();
        visited.add(word);
        if (word.equals(endWord)) {
          return step;
        }
        Set<String> adjacentWords = graph.get(word);
        for (String adjacentWord : adjacentWords) {
          if (visited.contains(adjacentWord)) {
            continue;
          }
          q.offer(adjacentWord);
        }
      }
      step++;
    }

    return 0;
  }
}
