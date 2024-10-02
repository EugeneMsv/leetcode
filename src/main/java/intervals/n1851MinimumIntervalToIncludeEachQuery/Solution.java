package intervals.n1851MinimumIntervalToIncludeEachQuery;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
 public int[] minInterval(int[][] intervals, int[] queries) {

  int[][] queriesWithIndex = new int[queries.length][2];
  for(int i = 0; i < queries.length; i++){
   queriesWithIndex[i] = new int[]{queries[i], i};
  }

  Arrays.sort(intervals, Comparator.<int[]> comparingInt(a -> a[0]).thenComparing(a -> a[1]) );
  Arrays.sort( queriesWithIndex, Comparator.<int[]>comparingInt(a -> a[0]));

  PriorityQueue<int[]> q =  new PriorityQueue<>((a, b) -> a[1]-a[0] - (b[1]-b[0]));

  int[] result =  new int[queries.length];
  int intIdx = 0;
  for(int qIdx = 0; qIdx < queriesWithIndex.length; qIdx++){
   int query =  queriesWithIndex[qIdx][0];

   while(intIdx < intervals.length && intervals[intIdx][0] <= query  ){
    q.offer(intervals[intIdx]);
    intIdx++;
   }

   while(!q.isEmpty() && q.peek()[1] < query){
    q.poll();
   }

   result[queriesWithIndex[qIdx][1]] = q.isEmpty() ? -1 : q.peek()[1] - q.peek()[0] +1;
  }

  return result;


 }




}