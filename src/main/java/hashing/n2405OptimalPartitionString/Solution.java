package hashing.n2405OptimalPartitionString;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int partitionString(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    Set<Character> letters = new HashSet<>();

    int i = 0;
    int partitions = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (letters.contains(c)) {
        partitions++;
        letters.clear();
      }
      letters.add(c);
      i++;
    }
    if (!letters.isEmpty()) {
      partitions++;
    }
    return partitions;

  }

  public int partitionStringBit(String s) {
    int i = 0, ans = 1, flag = 0;
    while (i < s.length()) {
      int val = s.charAt(i) - 'a';
      // for each char we have bit if it was already seen then bit will be 1
      if ((flag & (1 << val)) != 0) {
        flag = 0;
        ans++;
      }
      flag = flag | (1 << val);
      i++;
    }
    return ans;
  }
}