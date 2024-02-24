package greedy.n134GasStation;

public class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int gSum = 0;
    int cSum = 0;
    for (int i = 0; i < gas.length; i++) {
      gSum += gas[i];
      cSum += cost[i];
    }
    if (gSum < cSum) {
      return -1;
    }

    int start = 0;
    int total = 0;
    for (int i = 0; i < gas.length; i++) {
      total += gas[i] - cost[i];
      if (total < 0) {
        total = 0;
        start = i + 1;
      }
    }
    return start;
  }
}
