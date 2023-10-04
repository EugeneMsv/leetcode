package heap.n703KthLargestElement;

import java.util.PriorityQueue;

public class Solution {

  public static class KthLargest {

    private final PriorityQueue<Integer> heap;
    private final int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      heap = new PriorityQueue<>(nums.length > k ? nums.length : k);
      for (int i = 0; i < nums.length; i++) {
        heap.add(nums[i]);
      }
      while (heap.size() > k) {
        heap.poll();
      }

    }

    public int add(int val) {
      heap.add(val);
      if (heap.size() > k) {
        heap.poll();
      }
      return heap.peek();
    }
  }

}
