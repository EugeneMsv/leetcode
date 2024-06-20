package stack.n735AsteroidCollision;

import java.util.Stack;

public class Solution {

  public int[] asteroidCollision(int[] asteroids) {

    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {

      if (stack.isEmpty() || asteroid > 0) {
        stack.push(asteroid);
        continue;
      }

      boolean destroyed = false;
      while (!stack.isEmpty() && stack.peek() > 0) {
        int last = stack.peek();
        if (Math.abs(asteroid) < Math.abs(last)) {
          destroyed = true;
          break;
        }
        if (Math.abs(asteroid) == Math.abs(last)) {
          destroyed = true;
          stack.pop();
          break;
        }

        stack.pop();
      }
      if (!destroyed) {
        stack.push(asteroid);
      }

    }

    int[] result = new int[stack.size()];
    int i = stack.size() - 1;
    while (!stack.isEmpty()) {
      result[i--] = stack.pop();
    }

    return result;

  }
}
