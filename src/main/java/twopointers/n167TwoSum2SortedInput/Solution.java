package twopointers.n167TwoSum2SortedInput;

public class Solution {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (right > left) {
      int leftNum = numbers[left];
      while (right > left && numbers[right] > (target - leftNum)) {
        right--;
      }
      if (numbers[right] == (target - leftNum) && right != left) {
        return new int[]{left + 1, right + 1};
      }
      left++;
    }
    return new int[]{0, 0};

  }

}
