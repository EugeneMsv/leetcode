package hashing.n1461CheckIfAStringContainsAllBinaryCodesOfSizeK;

import java.util.HashSet;
import java.util.Set;

class Solution {
 public boolean hasAllCodes(String s, int k) {
  if(s.length() < k+k-1){
   return false;
  }
  char[] chars =  s.toCharArray();
  StringBuilder sb = new StringBuilder();
  for(int i = 0; i <k; i++){
   sb.append(chars[i]);
  }

  Set<Integer> nums =  new HashSet<>();
  nums.add(toInt(sb));

  for(int i =k; i< chars.length; i++){
   sb.deleteCharAt(0);
   sb.append(chars[i]);
   nums.add(toInt(sb));
  }


  return nums.size() ==Math.pow(2,k);
 }

 private int toInt(StringBuilder sb){
  return Integer.parseInt(sb.toString(), 2);
 }
}