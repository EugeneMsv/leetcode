package array.n128LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (Integer num : nums) {
      set.add(num);
    }

    int max = 0;
    for (Integer num : set) {
     //Because of it we won't run while loop for the elements in the middle of sequence, only for
     // beginning element
      if (set.contains(num - 1)) {
        continue;
      }

      Integer nextNum = num + 1;
      while (set.contains(nextNum)) {
        nextNum++;
      }
      max = Math.max(max, nextNum - num);
    }
    return max;
  }

  public int longestConsecutiveOLD(int[] nums) {
    Map<Integer, State> map = new HashMap<>();
    for (Integer num : nums) {
      map.put(num, new State());
    }

    for (Integer num : map.keySet()) {
      State currentState = map.get(num);
      if (currentState.visited) {
        continue;
      }

      Integer nextNum = num + 1;
      State nextState = map.get(nextNum);
      Integer curLength = currentState.length;
      while (nextState != null) {
        nextState.length += curLength;
        if (!nextState.visited) {
          curLength = nextState.length;
        }
        nextState.visited = true;

        nextNum = nextNum + 1;
        nextState = map.get(nextNum);
      }
      currentState.visited = true;
    }

    int maxLength = 0;
    for (State state : map.values()) {
      if (state.length > maxLength) {
        maxLength = state.length;
      }
    }
    return maxLength;
  }

  class State {

    boolean visited;
    Integer length = 1;
  }
}
