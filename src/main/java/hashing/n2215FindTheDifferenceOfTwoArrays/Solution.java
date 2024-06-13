package hashing.n2215FindTheDifferenceOfTwoArrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
 public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
  Map<Integer, Integer> map =  new HashMap<>();

  for(int num1 : nums1){
   Integer stored = map.getOrDefault(num1, 0);
   map.put(num1, 1);
  }


  for(int num2 : nums2){
   Integer stored = map.getOrDefault(num2, 0);
   map.put(num2, stored == 0 ? 2 : ((stored == 1 || stored ==3) ? 3 : 2));
  }


  List<Integer> nums1Only =  new LinkedList<>();
  List<Integer> nums2Only =  new LinkedList<>();

  for(Map.Entry<Integer,  Integer> entry : map.entrySet()){
   int position = entry.getValue();
   if(position == 1){
    nums1Only.add(entry.getKey());
   }
   if(position == 2){
    nums2Only.add(entry.getKey());
   }
  }

  return List.of(nums1Only, nums2Only);
 }
}