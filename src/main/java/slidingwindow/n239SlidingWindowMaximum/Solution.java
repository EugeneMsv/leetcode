package slidingwindow.n239SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

  public int[] maxSlidingWindowMine(int[] nums, int k) {
    TreeMap<Integer, Integer> window = new TreeMap<>();
    int i = 0;
    for (i = 0; i < k; i++) {
      window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
    }

    int[] result = new int[nums.length - k + 1];
    int j = 0;

    while (i < nums.length) {
      Map.Entry<Integer, Integer> last = window.lastEntry();
      result[j] = last.getKey();
      window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
      Integer value = window.get(nums[j]);
      if (value > 1) {
        window.put(nums[j], value - 1);
      } else {
        window.remove(nums[j]);
      }
      i++;
      j++;
    }

    result[j] = window.lastEntry().getKey();
    return result;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    // assume nums is not null
    int n = nums.length;
    if (n == 0 || k == 0) {
      return new int[0];
    }
    int[] result = new int[n - k + 1]; // number of windows
    Deque<Integer> win = new ArrayDeque<>(); // stores indices

    for (int i = 0; i < n; ++i) {
      // remove indices that are out of bound
      while (!win.isEmpty() && win.peekFirst() <= i - k) {
        win.pollFirst();
      }
      // remove indices whose corresponding values are less than nums[i]
      while (!win.isEmpty() && nums[win.peekLast()] < nums[i]) {
        win.pollLast();
      }
      // add nums[i]
      win.offerLast(i);
      // add to result
      if (i >= k - 1) {
        result[i - k + 1] = nums[win.peekFirst()];
      }
    }
    return result;
  }
}
