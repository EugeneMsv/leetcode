package stack.n496NextGreaterElement1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) {
        int el = stack.pop();
        map.put(el, num);
      }
      stack.push(num);
    }

    int[] result = new int[nums1.length];

    for (int i = 0; i < nums1.length; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }

    return result;

  }
}
