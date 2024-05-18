package bitmanipulation.n477TotalHammingDistance;

public class Solution {

  public int totalHammingDistance(int[] nums) {

    int total = 0;
    for (int i = 0; i < 32; i++) {

      int count1 = 0;
      int count0 = 0;
      for (int j = 0; j < nums.length; j++) {
        int num = nums[j];
        if (num % 2 == 1) {
          count1++;
        } else {
          count0++;
        }
        nums[j] = num >> 1;
      }
      total += count1 * count0;
    }

    return total;
  }

}
