package array.n118PascalsTriangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<List<Integer>> generate(int n) {
    List<List<Integer>> result = new ArrayList<>(n);
    result.add(List.of(1));
    for (int i = 1; i < n; i++) {

      List<Integer> prev = result.get(i - 1);
      List<Integer> cur = new LinkedList();
      cur.add(1);
      for (int j = 1; j < prev.size(); j++) {
        cur.add(prev.get(j - 1) + prev.get(j));

      }
      cur.add(1);
      prev = cur;
      result.add(cur);

    }
    return
        result;

  }
}