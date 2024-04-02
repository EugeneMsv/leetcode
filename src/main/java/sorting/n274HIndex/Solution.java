package sorting.n274HIndex;

public class Solution {

  public int hIndex(int[] citations) {
    int[] sorted = new int[1001];

    int max = 0;
    for (int citation : citations) {
      sorted[citation]++;
      max = Math.max(citation, max);
    }

    int count = 0;
    int idx = max;

    while (idx >= 0 && count < idx) {
      count += sorted[idx];
      if (count >= idx) {
        return idx;
      }
      idx--;
    }
    return idx;
  }
}
