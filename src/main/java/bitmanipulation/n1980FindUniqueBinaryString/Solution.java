package bitmanipulation.n1980FindUniqueBinaryString;

import java.util.HashSet;
import java.util.Set;

class Solution {
 public String findDifferentBinaryString(String[] strs) {
  Set<Integer> nums =  new HashSet<>();
  int n = strs[0].length();
  int lastIdxFreq = 0;
  for(int i = 0; i < strs.length; i++){
   nums.add(Integer.parseInt(strs[i],2));
   lastIdxFreq += (strs[i].charAt(n-1) == '1') ? 1: 0;
  }
  int max = (int)Math.pow(2, n);
  int candidate =  (lastIdxFreq < max/2) ? 1 :0;

  while(candidate < max){
   if(!nums.contains(candidate)){
    return String.format("%"+n+"s", Integer.toBinaryString(candidate)).replace(' ', '0');
   }
   candidate+=2;
  }

  return "-1";
 }
}