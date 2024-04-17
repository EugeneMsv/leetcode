package stack.n71SimplifyPath;

import java.util.Stack;

public class Solution {

  public String simplifyPath(String path) {
    String[] splitted = path.split("/");
    Stack<String> result = new Stack<>();

    for (String c : splitted) {
      if (c == null || c.isEmpty() || ".".equals(c)) {

        continue;

      }

      if ("..".equals(c)) {
        if (!result.isEmpty()) {
          result.pop();
        }
        continue;
      }
      result.add(c);
    }
    String s = "";
    while (!result.isEmpty()) {
      String element = result.pop();
      s = "/" + element + s;
    }
    if (s.isEmpty()) {
      s = "/";
    }
    return s;
  }
}