package string.n187RepeatedDNASequences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

 private static final Map<Character, Integer> HASH = Map.of('A', 1, 'C', 2, 'G', 3, 'T', 4);

 public List<String> findRepeatedDnaSequences(String s) {
  if(s.length() < 10){
   return List.of();
  }


  LinkedList<Character> window= new LinkedList<>();

  for(int i =0; i < 10; i++){
   window.offer(s.charAt(i));
  }
  Map<Long, Integer> met = new HashMap<>();
  met.put(hashCode(window),1);
  int end = 10;
  List<String> result = new LinkedList<>();
  while(end < s.length()){
   window.poll();
   window.offer(s.charAt(end));
   Long hashCode = hashCode(window);
   Integer freq = met.get(hashCode);

   if(freq == null){
    met.put(hashCode, 1);
   } else {
    if(freq ==1 ){

     met.put(hashCode,2);
     // put queue into List;
     result.add(window.stream()
         .map(String::valueOf)
         .collect(Collectors.joining()));
    }
   }
   end++;

  }

  return result;


 }

 private long hashCode(LinkedList<Character> list){

  long i = 1;
  long hash =0L;
  for(Character c : list){
   hash+=HASH.get(c)*i;
   i*=10L;
  }

  return hash;

 }

}
