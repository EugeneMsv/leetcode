package array.n448FindAllNumbersDissapearedInAnArray;

import java.util.LinkedList;
import java.util.List;

class Solution {
 public List<Integer> findDisappearedNumbers(int[] nums) {

  for( int i =0; i < nums.length; i++){
   if(nums[i] == i+1 || nums[i] ==-1){
    continue;
   }
   int j = nums[i];
   while(nums[j-1] != j && nums[j-1] != -1){
    int temp = nums[j-1];
    nums[j-1] = j;
    j = temp;

   }
  }

  List<Integer> result =  new LinkedList<>();

  for(int i =0; i< nums.length ; i++){
   if(nums[i] != i+1){
    result.add(i+1);
   }
  }
  return result;
 }
}