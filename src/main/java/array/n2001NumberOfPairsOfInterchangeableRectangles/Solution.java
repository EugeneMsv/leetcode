package array.n2001NumberOfPairsOfInterchangeableRectangles;

import java.util.HashMap;
import java.util.Map;

class Solution {
 public long interchangeableRectangles(int[][] rectangles) {
  Map<Double, Long> map = new HashMap<>();

  for(int[] rectangle : rectangles){
   Double key =  (double)rectangle[0]/rectangle[1];
   map.put(key, map.getOrDefault(key, 0L)+1);
  }
  long sum = 0L;

  for(Long value : map.values()){
   if(value >=2){
    sum+=value*(value-1)/2;
   }
  }
  return sum;
 }
}
