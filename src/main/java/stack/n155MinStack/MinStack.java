package stack.n155MinStack;

import java.util.Stack;

public class MinStack {

  private final Stack<Node> stack = new Stack<>();

  public MinStack() {

  }

  public void push(int val) {
    int currentMin = val;
    if (stack.size() > 0) {
      currentMin = stack.peek().minValue;
    }
    if (val < currentMin) {
      currentMin = val;
    }
    stack.push(new Node(val, currentMin));
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek().value;
  }

  public int getMin() {
    return stack.peek().minValue;
  }

  private class Node {

    private int value;
    private int minValue;

    public Node(int value, int minValue) {
      this.value = value;
      this.minValue = minValue;
    }
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(val); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
