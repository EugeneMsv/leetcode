package stack.n227BasicCalculator2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Solution {

  Set<Character> operators = Set.of('+', '-', '*', '/');

  static int pointer;

  public int calculate(String s) {

    pointer = 0;
    Deque<Integer> nums = new LinkedList<>();
    Deque<Character> operators = new LinkedList<>();
    Integer first = tryParseInt(s);
    if (first == null) {
      return 0;
    } else {
      nums.addLast(first);
    }

    boolean intMode = false;
    while (pointer < s.length()) {
      if (intMode) {
        Integer num = tryParseInt(s);
        intMode = !intMode;
        Character operator = operators.getLast();
        if (operator == '*') {
          num = nums.removeLast() * num;
          operators.removeLast();
        }
        if (operator == '/') {
          num = nums.removeLast() / num;
          operators.removeLast();
        }
        nums.addLast(num);

      } else {
        Character operator = tryParseOperator(s);
        if (operator == null) {
          break;
        }
        operators.addLast(operator);
        intMode = !intMode;
      }
    }

    int result = nums.removeFirst();
    while (!nums.isEmpty()) {
      char operator = operators.removeFirst();
      if (operator == '+') {
        result += nums.removeFirst();
      }
      if (operator == '-') {
        result -= nums.removeFirst();
      }
    }
    return result;

  }

  private Integer tryParseInt(String s) {
    StringBuilder sb = new StringBuilder();
    while (pointer < s.length() && s.charAt(pointer) == ' ') {
      pointer++;
    }
    while (pointer < s.length() && Character.isDigit(s.charAt(pointer))) {
      sb.append(s.charAt(pointer));
      pointer++;
    }
    return sb.isEmpty() ? null : Integer.valueOf(sb.toString());
  }

  private Character tryParseOperator(String s) {

    while (pointer < s.length() && !operators.contains(s.charAt(pointer))) {
      pointer++;
    }
    if (pointer < s.length()) {

      Character operator = s.charAt(pointer);
      pointer++;
      return operator;

    } else {
      return null;
    }
  }

}
