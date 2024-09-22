package hashing.n1189MaximumNumberOfBaloons;

import java.util.HashMap;
import java.util.Map;

class Solution {
 public int maxNumberOfBalloons(String text) {
  Map<Character, Integer> map =  new HashMap<>();

  map.put('b',0);
  map.put('a',0);
  map.put('l',0);
  map.put('o',0);
  map.put('n',0);

  for(char c : text.toCharArray()){
   Integer count = map.get(c);
   if(count !=null){
    map.put(c, count+1);
   }
  }

  int min = Integer.MAX_VALUE;
  for(int count: map.values()){
   min = Math.min(count,min);
  }

  int doubled =  map.get('l') < map.get('o') ? map.get('l') : map.get('o');
  return doubled >= min*2 ? min : doubled /2;
 }
}
