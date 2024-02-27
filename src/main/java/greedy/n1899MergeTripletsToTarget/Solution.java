package greedy.n1899MergeTripletsToTarget;

public class Solution {

  public boolean mergeTriplets(int[][] triplets, int[] target) {
    int[] candidate = new int[3];

    for (int[] triplet : triplets) {
      if (triplet[0] > target[0]
          || triplet[1] > target[1]
          || triplet[2] > target[2]) {
        continue;
      }
      candidate[0] = Math.max(candidate[0], triplet[0]);
      candidate[1] = Math.max(candidate[1], triplet[1]);
      candidate[2] = Math.max(candidate[2], triplet[2]);
    }
    return candidate[0] == target[0]
        && candidate[1] == target[1]
        && candidate[2] == target[2];

  }
}
