package array.n387FirstUniqueCharacterInAString;

class Solution {

  public int firstUniqChar(String s) {
    Integer[] dict = new Integer[26];
    int idx = 0;
    for (char c : s.toCharArray()) {
      int cIdx = c - 'a';
      Integer val = dict[cIdx];
      val = val == null ? idx : Integer.MAX_VALUE;
      dict[cIdx] = val;
      idx++;
    }

    int min = Integer.MAX_VALUE;
    for (Integer i : dict) {
      if (i != null) {
        min = Math.min(min, i);
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }
}