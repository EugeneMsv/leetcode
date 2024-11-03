package string.n438FindAllAnagramsInAString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
 public List<Integer> findAnagrams(String s, String p) {
  if(s.length() < p.length()){

   return List.of();
  }
  int n = p.length();
  Map<Character, Integer> pFreq = new HashMap<>();
  for(char c : p.toCharArray()){
   pFreq.put(c, pFreq.getOrDefault(c, 0)+1);
  }
  Map<Character, Integer> freq = new HashMap<>();

  for(int i =0; i < n-1; i++){
   Character c = s.charAt(i);
   freq.put(c,freq.getOrDefault(c,0)+1);
  }
  int start= 0;
  List<Integer> result = new LinkedList<>();
  while(start + n-1 < s.length()){
   char next = s.charAt(start+n-1);
   Integer m = freq.get(next);
   freq.put(next, m == null ? 1: m+1);
   //System.out.println(freq);
   if(pFreq.equals(freq)){
    result.add(start);
   }
   int count = freq.get(s.charAt(start));
   if(count == 1){
    freq.remove(s.charAt(start));
   }else {
    freq.put(s.charAt(start), count-1);
   }
   start++;
  }
  return result;
 }
}