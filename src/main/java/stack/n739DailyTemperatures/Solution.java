package stack.n739DailyTemperatures;

import java.util.Stack;

public class Solution {

  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Node> stack = new Stack<>();
    int[] daysToWarm = new int[temperatures.length];
    int day = 0;
    for (int temperature : temperatures) {
      Node node = new Node(temperature, day);
      if (stack.isEmpty()) {
        stack.push(node);
      } else {
        Node prevNode = stack.peek();
        while (prevNode != null && !stack.isEmpty() && node.temperature > prevNode.temperature) {
          prevNode = stack.pop();
          daysToWarm[prevNode.day] = node.day - prevNode.day;
          prevNode = stack.isEmpty() ? null : stack.peek();
        }
        stack.push(node);

      }

      day++;
    }
    return daysToWarm;
  }

  class Node {

    private final int temperature;
    private final int day;

    public Node(int temperature, int day) {
      this.temperature = temperature;
      this.day = day;
    }
  }
}
