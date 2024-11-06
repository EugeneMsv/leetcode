package array.n41FirstMissingPositive;

class Solution {
 public int firstMissingPositive(int[] nums) {
  for(int i =0 ; i< nums.length; i++){

   int num = nums[i];
   if(i != num-1){
    nums[i] = -1;
    int cur =  num;
    while(cur <= nums.length && cur >0 && cur!=nums[cur-1]){
     int next = nums[cur-1];
     nums[cur-1] =cur;
     cur = next;
    }

   }

  }
  for( int i = 0; i < nums.length; i++){
   if(nums[i] == -1){
    return i+1;
   }
  }

  return nums.length+1;
 }
}
