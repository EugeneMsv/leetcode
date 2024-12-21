package stack.n456_132Pattern;

import java.util.Stack;

class Solution {
 public boolean find132pattern(int[] nums) {

  int[] min = new int[nums.length];
  int curMin = Integer.MAX_VALUE;

  Stack<Integer> stack = new Stack<>();
  for(int i = 0; i < nums.length; i++){
   curMin = Math.min(curMin, nums[i]);
   min[i] = curMin;
  }

  for (int j = nums.length - 1; j >= 0; j--) {
   if (nums[j] > min[j]) {
    while (!stack.isEmpty() && stack.peek() <= min[j]) {
     stack.pop();
    }
    if (!stack.isEmpty() && stack.peek() < nums[j]){
     return true;
    }
    stack.push(nums[j]);
   }
  }
  return false;
 }


}
