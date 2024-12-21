package string.n844BackspaceStringCompare;

import java.util.Stack;

class Solution {
 public boolean backspaceCompare(String s, String t) {
  Stack<Character> sStack =  calc(s);
  Stack<Character> tStack =  calc(t);
  if(sStack.size() != tStack.size()){
   return false;
  }

  while(!sStack.isEmpty()){
   if(!sStack.pop().equals(tStack.pop())){
    return false;
   }
  }

  return true;

 }

 private Stack<Character> calc(String s){
  Stack<Character> stack = new Stack<>();

  for(char c : s.toCharArray()){
   if(c == '#' && !stack.isEmpty()){
    stack.pop();
   }
   if(c != '#'){
    stack.push(c);
   }
  }

  return stack;
 }
}