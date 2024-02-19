package bitmanipulation.n268MissingNumber;

public class Solution {

  public int missingNumber(int[] nums) {

    int result = 0;
    int idx = 0;
    for (int num : nums) {
      result = result ^ num ^ idx;
      idx++;
    }
    return result ^ idx;
  }
}