package heap.n373FindKPairswithSmallestSums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    //In the minHeap array, 0th element refers to the curr element in nums1 and 1st element refers to curr element in nums2
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

    // The 2nd element in the minHeap is the index of nums2, the corresponding element of nums2 is in index1 of minHeap
   for (int i = 0; i < nums1.length && i < k; i++) {
    minHeap.add(new int[]{nums1[i], nums2[0], 0});
   }

    List<List<Integer>> result = new ArrayList<>();

    /*
     * Now we poll out each element from the minHeap
     * and at the same time we add the pair of the next nums2[] element
     * and the curr polled element of nums1 in the minHeap until we get k elements OR the minHeap is empty
     * For getting the next nums2 element we can store the curr index of nums2 in the minHeap
     * when we are storing the nums1 and nums2 pair.
     */
    for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
      int[] curr = minHeap.poll();
      result.add(List.of(curr[0], curr[1]));
      int nums2Idx = curr[2];
     if (nums2Idx < nums2.length - 1) {
      minHeap.add(new int[]{curr[0], nums2[nums2Idx + 1], nums2Idx + 1});
     }
    }
    return result;
  }
}
