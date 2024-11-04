package greedy.n665NonDecreasingArray;

class Solution {
 public boolean checkPossibility(int[] nums) {
  if(nums.length <=2 ){
   return true;
  }
  int descCount = 0;

  for(int i = 1; i < nums.length; i++){
   if(nums[i] < nums[i-1]){
    int count = 1;
    boolean prevHigh = i-2 >=0 && nums[i] < nums[i-2];
    boolean nextLess = i+1 < nums.length && nums[i+1] < nums[i-1];
    if(prevHigh && nextLess){
     count+=1;
    }
    descCount+=count;
   }
  }

  return descCount <= 1;
 }
}
