package linkedlist.n287FindDuplicateNumber;

public class Solution {

  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;
    // Floyd's cycle detection
    while (fast != slow || slow == 0) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    int begin = 0;
    while (begin != slow) {
      slow = nums[slow];
      begin = nums[begin];
    }
    return slow;
  }
}
