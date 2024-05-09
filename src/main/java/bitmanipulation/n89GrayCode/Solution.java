package bitmanipulation.n89GrayCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<Integer> grayCode(int n) {

    Set<Integer> used = new HashSet<>();

    used.add(0);

    List<Integer> result = new ArrayList<>();
    result.add(0);

    int count = (int) Math.pow(2, n) - 1;
    while (count > 0) {
      int last = result.get(result.size() - 1);
      int position = 0;
      while (used.contains(flipBitAt(last, position))) {
        position++;
      }
      int next = flipBitAt(last, position);
      used.add(next);
      result.add(next);
      count--;
    }

    return result;
  }

  private int flipBitAt(int value, int position) {
    return (1 << position) ^ value;
  }

  private int getBitAt(int value, int position) {
    return (value >> position) & 1;
  }
}
