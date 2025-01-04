package stack.n1249MinimumRemoveToMakeValidParentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
 public String minRemoveToMakeValid(String s) {
  Stack<Integer> stack =  new Stack<>();
  Set<Integer> valid = new HashSet<>();

  for(int i = 0; i < s.length(); i++){
   char c = s.charAt(i);
   if(c == '('){
    stack.push(i+1);
   }
   if(c == ')'){
    if(!stack.isEmpty() && stack.peek() > 0){
     int left = stack.pop();
     valid.add(left-1);
     valid.add(i);
    }else{
     stack.push(-(i+1));
    }
   }
  }

  StringBuilder sb = new StringBuilder();
  for(int i = 0; i < s.length(); i++){
   char c = s.charAt(i);
   if(c == '(' || c == ')') {
    if(valid.contains(i)){
     sb.append(c);
    }
   }else{
    sb.append(c);
   }
  }

  return sb.toString();
 }
}
