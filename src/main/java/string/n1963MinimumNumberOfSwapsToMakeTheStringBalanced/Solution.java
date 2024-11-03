package string.n1963MinimumNumberOfSwapsToMakeTheStringBalanced;

import java.util.Stack;

class Solution {
 public int minSwaps(String s) {
  Stack<Character> stack = new Stack<>();

  for(char bracket : s.toCharArray()){

   if(stack.isEmpty()){
    stack.push(bracket);
    continue;
   }

   if(bracket == ']' && stack.peek() == '['){
    stack.pop();
   } else{
    stack.push(bracket);
   }

  }
  return (stack.size()/2+1)/2;
 }
}
