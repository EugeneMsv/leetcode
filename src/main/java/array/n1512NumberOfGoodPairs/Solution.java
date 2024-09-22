package array.n1512NumberOfGoodPairs;

class Solution {

  public int numIdenticalPairs(int[] nums) {
    int[] freq = new int[101];

    for (int num : nums) {
      freq[num] += 1;
    }

    int result = 0;

    for (int f : freq) {

      int sum = f > 0 ? f * (f - 1) / 2 : 0;
      result += sum;
    }

    return result;
  }
}
