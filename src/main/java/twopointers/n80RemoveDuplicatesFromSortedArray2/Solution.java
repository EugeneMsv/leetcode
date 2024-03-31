package twopointers.n80RemoveDuplicatesFromSortedArray2;

public class Solution {

  public int removeDuplicates(int[] nums) {
    int write = 1;
    int read = 1;

    int repeatedCandidate = nums[0];
    int repetitions = 1;

    while (read < nums.length) {
      int current = nums[read];

      if (current == repeatedCandidate) {
        repetitions++;
        if (repetitions <= 2) {
          nums[write] = nums[read];
          write++;
        }
      } else {
        // If we see the number for the first time
        repeatedCandidate = current;
        repetitions = 1;
        nums[write] = nums[read];
        write++;
      }
      read++;
    }
    return write;
  }
}
