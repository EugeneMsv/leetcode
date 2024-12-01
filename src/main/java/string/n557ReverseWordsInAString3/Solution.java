package string.n557ReverseWordsInAString3;

class Solution {
 public String reverseWords(String s) {

  StringBuilder sb =  new StringBuilder();

  for(String word : s.split(" ")){
   sb.append(reverse(word)).append(' ');
  }

  return sb.toString().trim();
 }

 private String reverse(String in){
  StringBuilder sb =  new StringBuilder();

  for(int i = in.length()-1; i >=0; i--){
   sb.append(in.charAt(i));
  }

  return sb.toString();
 }
}
