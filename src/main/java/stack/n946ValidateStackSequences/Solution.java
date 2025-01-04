package stack.n946ValidateStackSequences;

import java.util.Stack;

class Solution {
 public boolean validateStackSequences(int[] pushed, int[] popped) {
  Stack<Integer> stack =  new Stack<>();

  int i = 0;
  int j = 0;

  while(i < pushed.length && j < popped.length){
   if(stack.isEmpty()){
    stack.push(pushed[i]);
    i++;
   }else{
    if(stack.peek() == popped[j]){
     stack.pop();
     j++;
    }else{
     stack.push(pushed[i]);
     i++;
    }
   }
  }
  for(int k = j; k < popped.length; k++){
   if(stack.peek() == popped[k]){
    stack.pop();
   }
  }

  return stack.isEmpty();
 }
}