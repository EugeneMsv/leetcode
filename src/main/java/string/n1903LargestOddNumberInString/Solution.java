package string.n1903LargestOddNumberInString;

class Solution {
 public String largestOddNumber(String num) {

  int result = -1;
  for(int i = num.length() -1 ; i>=0; i--){
   int digit = Character.getNumericValue(num.charAt(i));

   if(digit % 2 == 1){
    result = i;
    break;
   }
  }

  return num.substring(0,result+1);
 }
}
