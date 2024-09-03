package heap.n3275KthNearestObstacleQueries;

import java.util.PriorityQueue;

class Solution {
 public int[] resultsArray(int[][] queries, int k) {
  PriorityQueue<Integer> pq =  new PriorityQueue<>((a, b)  -> b-a);
  int[] result =  new int[queries.length];
  int i = 0;
  for(int[] query : queries){
   pq.offer(Math.abs(query[0])+ Math.abs(query[1]));
   if(pq.size() < k){
    result[i] = -1;
   } else{

    while(pq.size() > k){
     pq.poll();
    }
    result[i]=pq.peek();
   }

   i++;
  }

  return result;

 }
}
