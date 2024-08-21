package stack.n84LargestRectangleInHistogram;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

  public int largestRectangleArea(int[] heights) {

    Stack<Element> stack = new Stack<>();

    List<Element> elements = new ArrayList<>(heights.length);

    for (int h : heights) {
      elements.add(new Element(h));
    }

    // Calc higher elements count on the right side
    for (int i = 0; i < elements.size(); i++) {
      Element curEl = elements.get(i);
      if (!stack.isEmpty() && stack.peek().h > curEl.h) {
        int accumulatedHigher = 0;

        while (!stack.isEmpty() && stack.peek().h > curEl.h) {
          Element el = stack.pop();
          el.rightHiger += accumulatedHigher;
          accumulatedHigher = el.rightHiger + 1;
        }
        if (!stack.isEmpty()) {
          stack.peek().rightHiger += accumulatedHigher;
        }
      }
      stack.push(curEl);
    }
    int acc = 0;

    while (!stack.isEmpty()) {
      Element el = stack.pop();
      el.rightHiger += acc;
      acc = el.rightHiger + 1;
    }
    // System.out.println(elements);
    // System.out.println("--------------------------------");

    // Calc higher elements count on the left side
    for (int i = elements.size() - 1; i >= 0; i--) {
      Element curEl = elements.get(i);
      if (!stack.isEmpty() && stack.peek().h > curEl.h) {
        int accumulatedHigher = 0;

        while (!stack.isEmpty() && stack.peek().h > curEl.h) {
          Element el = stack.pop();
          el.leftHigher += accumulatedHigher;
          accumulatedHigher = el.leftHigher + 1;
        }
        if (!stack.isEmpty()) {
          stack.peek().leftHigher += accumulatedHigher;
        }
      }
      stack.push(curEl);
    }

    acc = 0;
    while (!stack.isEmpty()) {
      Element el = stack.pop();
      el.leftHigher += acc;
      acc = el.leftHigher + 1;
    }

    int maxSq = 0;
    for (Element el : elements) {
      maxSq = Math.max(maxSq, el.h * (el.rightHiger + el.leftHigher + 1));
    }
    // System.out.println(elements);
    return maxSq;

  }

  private static class Element {

    int h;
    int rightHiger;
    int leftHigher;

    public Element(int h) {
      this.h = h;
    }

    public String toString() {
      return "{h = %s, hR = %s, hL = %s}".formatted(h, rightHiger, leftHigher);
    }
  }
}