package stack.n150EvalReversePolishNotation;

import java.util.Stack;

public class Solution {

  public int evalRPN(String[] tokens) {
    Stack<Integer> operands = new Stack<>();

    for (String token : tokens) {
      if ("+".equals(token)
          || "-".equals(token)
          || "*".equals(token)
          || "/".equals(token)) {

        int right = operands.pop();
        int left = operands.pop();
        if ("+".equals(token)) {
          operands.push(left + right);
        }
        if ("-".equals(token)) {
          operands.push(left - right);
        }
        if ("*".equals(token)) {
          operands.push(left * right);
        }
        if ("/".equals(token)) {
          operands.push(left / right);
        }
      } else {
        int number = Integer.parseInt(token);
        operands.push(number);
      }
    }
    return operands.pop();
  }
}
