package hashing.n169MajorityElement;

import java.util.HashMap;
import java.util.Map;

class Solution {
 public int majorityElement(int[] nums) {
  Map<Integer, Integer> freq = new HashMap<>();

  for(int num: nums){
   freq.put(num, freq.getOrDefault(num, 0)+1);
  }
  int half = nums.length / 2;
  for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
   if(entry.getValue()> half){
    return entry.getKey();
   }
  }
  return -1;
 }
}
