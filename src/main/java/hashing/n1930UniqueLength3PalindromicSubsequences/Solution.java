package hashing.n1930UniqueLength3PalindromicSubsequences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
 public int countPalindromicSubsequence(String s) {
  Map<Character, Result> map =  new HashMap<>();
  char[] chars = s.toCharArray();
  for(int i =0; i < chars.length;  i++){
   char c = chars[i];
   Result r = map.getOrDefault(c, new Result());
   boolean minExists = r.hasMin();
   r.min =  Math.min(r.min, i);
   if(minExists){
    r.max =  Math.max(r.max, i);
   }
   map.put(c, r);
  }

  int count = 0;
  Set<Character> met =  new HashSet<>();
  for(Map.Entry<Character, Result> entry : map.entrySet()){
   Character c = entry.getKey();
   Result result = entry.getValue();
   int localCount = 0;
   met.clear();
   if(result.has()){
    for(int i = result.min+1; i < result.max; i++){
     if(!met.contains(chars[i])){
      met.add(chars[i]);
      localCount++;
     }
    }
   }
   count+=localCount;

  }
  return count;
 }

 class Result {
  Integer min = Integer.MAX_VALUE;
  Integer max = Integer.MIN_VALUE;

  boolean has(){
   return hasMin() && hasMax();
  }

  boolean hasMin(){
   return min != Integer.MAX_VALUE;
  }

  boolean hasMax(){
   return max != Integer.MIN_VALUE;
  }

  public String toString(){
   return "[%s,%s]".formatted(min,max);
  }
 }
}