package stack.n901OnlineStockSpan;

import java.util.Stack;

class StockSpanner {

  Stack<int[]> stack;

  public StockSpanner() {
    stack = new Stack<>();

  }

  public int next(int price) {
    if (stack.isEmpty()) {
      stack.push(new int[]{price, 1});
      return 1;
    }
    int span = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      int[] el = stack.pop();
      span += el[1];
    }
    stack.push(new int[]{price, span});

    return span;
  }
}