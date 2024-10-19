package array.n1624LargestSubstringBetweenTwoEqualCharacters;

class Solution {

  public int maxLengthBetweenEqualCharacters(String s) {

    Integer[][] dict = new Integer[26][2];

    int cIdx = 0;
    for (char c : s.toCharArray()) {
      int dictIdx = c - 'a';
      Integer[] indexes = dict[dictIdx];
      if (indexes == null) {
        indexes = new Integer[2];
      }
      if (indexes[0] == null) {
        indexes[0] = cIdx;
      } else {
        indexes[1] = cIdx;
      }
      dict[dictIdx] = indexes;
      cIdx++;
    }
    // System.out.println(Arrays.deepToString(dict));
    int max = -1;
    for (Integer[] indexes : dict) {
      if (indexes != null && indexes[0] != null && indexes[1] != null) {
        max = Math.max(max, indexes[1] - indexes[0] - 1);
      }
    }

    return max;
  }
}