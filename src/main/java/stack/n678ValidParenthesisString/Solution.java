package stack.n678ValidParenthesisString;

import java.util.Stack;

public class Solution {

  public boolean checkValidString(String s) {
    // Initialize two stacks to keep track of indices of left parentheses and asterisks
    Stack<Integer> leftParen = new Stack<>();
    Stack<Integer> asterisk = new Stack<>();

    // Iterate through each character in the string

    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == '(') {
        // Add the index of the left parenthesis to the left_paren_stack
        leftParen.push(i);
      } else if (s.charAt(i) == '*') {
        // Add the index of the asterisk to the asterisk_stack
        asterisk.push(i);
      } else {
        // s.charAt(i) == ')' If there is a left parenthesis in the left_paren_stack, pop it
        if (!leftParen.isEmpty()) {
          leftParen.pop();
        } else if (!asterisk.isEmpty()) {
          // Otherwise, if there is an asterisk in the asterisk_stack, pop it
          asterisk.pop();
        } else {
          // If there is neither a left parenthesis nor an asterisk to match the right parenthesis, the string is invalid
          return false;
        }
      }
    }

    // Iterate through the remaining elements in the left_paren_stack and asterisk_stack
    while (!leftParen.isEmpty() && !asterisk.isEmpty()) {
      // If the index of the left parenthesis is greater than the index of the asterisk, the string is invalid
      if (leftParen.pop() > asterisk.pop()) {
        return false;
      }
    }
    // If there are no more left parentheses to match the asterisks, the string is valid
    return leftParen.isEmpty();
  }
}
