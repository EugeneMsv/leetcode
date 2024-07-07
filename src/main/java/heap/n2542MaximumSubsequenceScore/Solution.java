package heap.n2542MaximumSubsequenceScore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
 public long maxScore(int[] nums1, int[] nums2, int k) {

  int n = nums2.length;
  List<int[]> nums = new ArrayList<>(n);

  for(int i = 0;  i < nums2.length;  i++){
   nums.add(new int[]{nums1[i], nums2[i]});
  }

  Collections.sort(nums, (a, b) -> Integer.compare(b[1], a[1]));
  PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));
  long max = 0;
  long sum1 = 0;

  for (int[] num : nums) {
   pq.add(num[0]);
   sum1 += num[0];
   if (pq.size() > k) {
    sum1 -= pq.poll();
   }
   if (pq.size() == k) {
    max = Math.max(max, (sum1 * num[1]));
   }
  }
  return max;

 }

}
