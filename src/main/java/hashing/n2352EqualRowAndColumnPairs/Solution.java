package hashing.n2352EqualRowAndColumnPairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
 public int equalPairs(int[][] grid) {

  Map<String, Integer> hash =  new HashMap<>();

  StringBuilder sb= new StringBuilder();
  for( int row = 0; row < grid.length; row++){
   for( int column = 0; column < grid[row].length; column++){
    sb.append(grid[row][column]).append(",");
   }
   String key = sb.toString();
   hash.put(key, hash.getOrDefault(key, 0)+1);
   sb.setLength(0);
  }

  int match = 0;
  sb.setLength(0);
  for( int column = 0; column < grid[0].length; column++){
   for( int row = 0; row < grid.length; row++){
    sb.append(grid[row][column]).append(",");
   }

   match+=hash.getOrDefault(sb.toString(), 0);

   sb.setLength(0);
  }

  return match;

 }
}
