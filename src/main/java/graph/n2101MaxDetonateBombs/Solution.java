package graph.n2101MaxDetonateBombs;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int maximumDetonation(int[][] bombs) {
    Set<Integer> detonated = new HashSet<>();
    int maximumDetonated = 0;
    for (int bomb = 0; bomb < bombs.length; bomb++) {
      calcDetonated(detonated, bombs, bomb);
      maximumDetonated = Math.max(maximumDetonated, detonated.size());
      detonated.clear();
    }
    return maximumDetonated;
  }

  void calcDetonated(Set<Integer> alreadyDetonated, int[][] bombs, int rootBomb) {
    alreadyDetonated.add(rootBomb);
    for (int bomb = 0; bomb < bombs.length; bomb++) {
      if (alreadyDetonated.contains(bomb)) {
        // skip already detonated
        continue;
      }

      long distance = calcDistanceSquared(
          bombs[rootBomb][0], bombs[rootBomb][1], bombs[bomb][0], bombs[bomb][1]);

      // if bomb in radius of the rootBomb
      if ((long) bombs[rootBomb][2] * bombs[rootBomb][2] >= distance) {
        calcDetonated(alreadyDetonated, bombs, bomb);
      }
    }
  }

  long calcDistanceSquared(int x1, int y1, int x2, int y2) {
    return (long) (x2 - x1) * (x2 - x1) + (long) (y2 - y1) * (y2 - y1);
  }
}
