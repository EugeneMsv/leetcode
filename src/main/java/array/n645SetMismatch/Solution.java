package array.n645SetMismatch;

class Solution {

  public int[] findErrorNums(int[] nums) {
    int[] freq = new int[nums.length + 1];

    for (int num : nums) {
      freq[num] += 1;
    }

    int[] result = new int[2];

    for (int i = 1; i < freq.length; i++) {
      if (freq[i] == 2) {
        result[0] = i;
      }
      if (freq[i] == 0) {
        result[1] = i;
      }
    }

    return result;
  }
}
