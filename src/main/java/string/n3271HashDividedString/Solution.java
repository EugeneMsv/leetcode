package string.n3271HashDividedString;

class Solution {
 public String stringHash(String s, int k) {
  int m = s.length()/k;
  char[] result =  new char[m];

  int sum = charToInt(s.charAt(0));
  for(int i = 1; i < s.length(); i++){
   if(i % k == 0){
    result[i/k-1] = intToChar(sum);
    sum=0;
   }
   sum+=charToInt(s.charAt(i));
  }
  result[m-1] = intToChar(sum);

  return new String(result);
 }

 private int charToInt(char c){
  return c - (int)'a';
 }

 private char intToChar(int num){
  return (char)((int)'a' +(num % 26));
 }
}
