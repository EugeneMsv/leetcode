package greedy.n846HandOnStraights;

import java.util.Arrays;

public class Solution {

  //Greedy
  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }
    Arrays.sort(hand);
    int groups = hand.length / groupSize;

    for (int group = 1; group <= groups; group++) {

      int min = Integer.MAX_VALUE;
      int minIdx = -1;
      for (int i = 0; i < hand.length; i++) {
        int v = hand[i];
        if (v >= 0 && v < min) {
          min = v;
          minIdx = i;
          break;
        }
      }

      hand[minIdx] = -1;

      int lastInGroup = min;
      int curGroupSize = 1;
      for (int i = 0; i < hand.length; i++) {
        if (curGroupSize == groupSize) {
          break;
        }
        int v = hand[i];
        if (v < 0) {
          continue;
        }
        if (v == lastInGroup + 1) {
          curGroupSize++;
          lastInGroup = v;
          hand[i] = -1;
        }
      }
      if (curGroupSize < groupSize) {
        return false;
      }
    }

    return true;

  }

}