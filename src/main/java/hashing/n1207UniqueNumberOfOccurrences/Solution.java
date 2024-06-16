package hashing.n1207UniqueNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> occurencies = new HashMap<>();
    for (int num : arr) {
      int freq = occurencies.getOrDefault(num, 0);
      occurencies.put(num, freq + 1);
    }

    Set<Integer> metBefore = new HashSet<>();
    for (int num : occurencies.values()) {
      boolean added = metBefore.add(num);
      if (!added) {
        return false;
      }
    }
    return true;
  }
}
