package graph.n802FindEventualSafeStates;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<Integer> eventualSafeNodes(int[][] graph) {

    // To search fast of the one who refers to the node
    Map<Integer, Set<Integer>> backReferences = new HashMap<>();
    // O(N*M)
    for (int node = 0; node < graph.length; node++) {
      for (int neighbour : graph[node]) {
        Set<Integer> references = backReferences.get(neighbour);
        if (references == null) {
          references = new HashSet<>();
          backReferences.put(neighbour, references);
        }
        references.add(node);
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    // O(N) Add all nodes who doesn't depend on anyone
    for (int node = 0; node < graph.length; node++) {
      if (graph[node].length == 0) {
        queue.offer(node);
      }
    }

    List<Integer> safeNodes = new LinkedList<>();

    // O(N*M)
    while (!queue.isEmpty()) {
      Integer safeNode = queue.poll();
      safeNodes.add(safeNode);

      Set<Integer> references = backReferences.get(safeNode);

      if (references == null) {
        continue;
      }

      // Check all node who refers to the current safeNode
      for (Integer reference : references) {
        int[] forwardReferences = graph[reference];
        int unlinked = 0;

        for (int i = 0; i < forwardReferences.length; i++) {

          if (forwardReferences[i] == safeNode) {
            // Unlink the current safeNode
            forwardReferences[i] = -1;
          }
          if (forwardReferences[i] == -1) {
            unlinked++;
          }
        }
        // All nodes already unlinked then it's ready for processing
        if (unlinked == forwardReferences.length) {
          queue.offer(reference);
        }
      }
      backReferences.remove(safeNode);

    }
    // Sort in ascending
    Collections.sort(safeNodes);
    return safeNodes;
  }
}
