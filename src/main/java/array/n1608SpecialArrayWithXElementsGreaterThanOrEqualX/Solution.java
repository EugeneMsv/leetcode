package array.n1608SpecialArrayWithXElementsGreaterThanOrEqualX;

import java.util.Arrays;

class Solution {
 public int specialArray(int[] nums) {
  Arrays.sort(nums);

  for(int i = 0; i < nums.length; i++){
   int candidate = nums.length - i;

   if(nums[i] >= candidate && (i ==0 || nums[i-1] < candidate)){
    return candidate;
   }
  }
  return -1;
 }
}
