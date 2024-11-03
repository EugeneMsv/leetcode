package array.n523ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

class Solution {
 public boolean checkSubarraySum(int[] nums, int k) {
  int[] prefixSum =  new int[nums.length];
  int sum =0;
  for(int i= 0 ; i < nums.length; i++){
   sum+=nums[i];
   prefixSum[i]=sum%k;
  }

  Map<Integer, Integer> met = new HashMap<>();
  met.put(0,-1);

  for(int i =0 ; i < prefixSum.length; i++){
   int prefix  = prefixSum[i];
   if(met.containsKey(prefix) ){
    if(i-met.get(prefix)>1){
     return true;
    }

   } else {
    met.put(prefix,i);

   }
  }

  return false;

 }
}
