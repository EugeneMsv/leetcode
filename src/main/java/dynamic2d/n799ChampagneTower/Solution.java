package dynamic2d.n799ChampagneTower;

import java.util.HashMap;
import java.util.Map;

class Solution {
 static int total;
 public double champagneTower(int poured, int targetRow, int targetGlass) {
  total =  poured;

  return Math.min(1.0, dp(new HashMap<>(), targetRow, targetGlass));
 }

 private double dp(Map<String, Double> memo, int i, int j){

  // if any of the condition fails
  if(i < 0 || j > i || j < 0)
  {
   return 0.0;
  }

  if(i ==0 && j ==0){
   return (double)total;
  }
  String key =  i+";"+j;

  Double result =  memo.get(key);
  if(result !=null){
   return result;
  }

  double left =(dp(memo,i-1, j-1)-1)/2;

  if(left < 0){
   left = 0.0;
  }

  double right =(dp(memo, i-1, j)-1)/2;

  if(right < 0){
   right = 0.0;
  }
  result = left+right;
  memo.put(key, result);
  return result;
 }
}
