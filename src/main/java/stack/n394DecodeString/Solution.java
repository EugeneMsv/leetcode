package stack.n394DecodeString;

import java.util.Stack;

public class Solution {

  public String decodeString(String s) {

    Stack<Integer> times = new Stack<>();
    Stack<String> chars = new Stack<>();

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        times.push(Character.getNumericValue(c));
        continue;
      }
      if ("[".equals(String.valueOf(c))) {
        // Marker
        times.push(-1);
        chars.push("[");
        continue;
      }

      if ("]".equals(String.valueOf(c))) {

        String toRepeat = buildStringToRepeat(chars);
        int repeat = buildTimesToRepeat(times);
        String repeated = "";
        for (int i = 1; i <= repeat; i++) {
          repeated += toRepeat;
        }
        if (repeat > 0) {
          chars.push(repeated);
          times.push(-1);
        }

      } else {
        // it means only letters left
        chars.push(String.valueOf(c));
      }

    }

    return buildStringToRepeat(chars);
  }

  private String buildStringToRepeat(Stack<String> chars) {
    String localResult = "";
    while (!chars.isEmpty() && !"[".equals(chars.peek())) {
      String prev = chars.pop();
      localResult = prev + localResult;
    }

    if (!chars.isEmpty()) {
      // Remove last [
      chars.pop();
    }
    return localResult;
  }

  private int buildTimesToRepeat(Stack<Integer> times) {
    int n = 0;
    int multiplier = 1;
    if (!times.isEmpty() && times.peek() < 0) {
      times.pop();
    }
    while (!times.isEmpty() && times.peek() >= 0) {
      n = n + multiplier * times.pop();
      multiplier *= 10;
    }
    if (!times.isEmpty()) {
      // Remove last -1
      times.pop();
    }
    return n;
  }

}