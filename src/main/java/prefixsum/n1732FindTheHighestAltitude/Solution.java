package prefixsum.n1732FindTheHighestAltitude;

public class Solution {

  public int largestAltitude(int[] gain) {
    int curAltitude = 0;
    int maxAltitude = 0;

    for (int i = 0; i < gain.length; i++) {
      curAltitude += gain[i];
      maxAltitude = Math.max(maxAltitude, curAltitude);
    }

    return maxAltitude;
  }
}
