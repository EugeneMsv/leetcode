package array.n1299ReplaceWithTheGreatestElementOfRightSide;

class Solution {
 public int[] replaceElements(int[] nums) {
  int max = -1;

  for(int i =  nums.length-1; i>=0; i-- ){
   int temp =  nums[i];
   nums[i] = max;
   max= Math.max(temp, max);
  }
  return nums;
 }
}
