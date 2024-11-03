package array.n179LargestNumber;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
 public String largestNumber(int[] nums) {
  return Arrays.stream(nums)
      .boxed()
      .sorted((l, r) -> isLess2(l,r) ? 1 : -1) // because we want reversed order, larger is first
      .map(String::valueOf)
      .collect(Collectors.joining())
      .replaceFirst("^0+(?!$)", "");



 }


 private boolean isLess(int left, int right){
  char[] l = String.valueOf(left).toCharArray();
  char[] r = String.valueOf(right).toCharArray();
  if(l[0]== r[0]){
   int lIdx = 0;
   int rIdx =0;
   int i =0;
   int end = Math.max(l.length, r.length);
   while( i < end){
    int lNum = numOf(l[lIdx]);
    int rNum = numOf(r[rIdx]);
    if( lNum == rNum){
     if(lIdx < l.length -1){
      lIdx++;
     }
     if(rIdx < r.length -1){
      rIdx++;
     }
     i++;

    } else {
     return lNum < rNum;
    }
   }
   return true;
  }else {
   return numOf(l[0]) < numOf(r[0]);
  }
 }

 private boolean isLess2(int left, int right){
  BigInteger lr =  new BigInteger(String.valueOf(left)+String.valueOf(right));
  BigInteger rl =  new BigInteger(String.valueOf(right)+String.valueOf(left));
  return rl.compareTo(lr) > 0;
 }

 private int numOf(char c){
  return Character.getNumericValue(c);
 }
}
