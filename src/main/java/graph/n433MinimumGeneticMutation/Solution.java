package graph.n433MinimumGeneticMutation;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int minMutation(String startGene, String endGene, String[] bank) {

    Queue<String> genes = new LinkedList<>();
    genes.offer(startGene);

    int min = Integer.MAX_VALUE;
    int mutations = 0;
    boolean[] visited = new boolean[bank.length];
    while (!genes.isEmpty()) {
      int size = genes.size();

      for (int i = 0; i < size; i++) {
        String gene = genes.poll();
        if (gene.equals(endGene)) {
          min = Math.min(min, mutations);
        } else {
          // Find all non-visited next for gene
          int start = 0;
          while (start < bank.length) {
            int nextGeneIdx = findNext(bank, gene, start, visited);
            if (nextGeneIdx < 0) {
              break;
            } else {
              visited[nextGeneIdx] = true;
              String nextGene = bank[nextGeneIdx];
              genes.offer(nextGene);
              start = nextGeneIdx + 1;
            }

          }

        }

      }
      mutations++;
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private int findNext(String[] bank, String gene, int start, boolean[] visited) {
    for (int i = start; i < bank.length; i++) {
      if (visited[i]) {
        continue;
      }
      int diff = 0;
      String nextCandidate = bank[i];
      for (int j = 0; j < 8; j++) {
        if (gene.charAt(j) != nextCandidate.charAt(j)) {
          diff++;
        }
      }

      if (diff == 1) {
        return i;
      }
    }

    return -1;

  }
}
