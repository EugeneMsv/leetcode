package heap.n554BrickWall;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
 public int leastBricks(List<List<Integer>> wall) {
  int n = wall.get(0).stream().mapToInt(Integer::intValue).sum();

  PriorityQueue<int[]> pq =  new PriorityQueue<>((a, b) -> a[0] -b[0]);

  for(int i = 0;  i < wall.size(); i++){

   pq.offer(new int[]{wall.get(i).get(0), 0,i});
  }
  int min = wall.size();
  Queue<int[]> toIncrease = new LinkedList<>();
  while(!pq.isEmpty()){

   int prefixSum = pq.peek()[0];
   if(prefixSum == n){
    break;
   }

   while(!pq.isEmpty() && pq.peek()[0] == prefixSum){
    toIncrease.offer(pq.poll());
   }
   min =  Math.min(min, pq.size());

   while(!toIncrease.isEmpty()){
    int[] prefix = toIncrease.poll();
    List<Integer> row =  wall.get(prefix[2]);
    int next =  prefix[1]+1 < row.size() ? row.get(prefix[1]+1) : 0;
    prefix[1]+=1;
    prefix[0]+=next;
    pq.offer(prefix);
   }
  }



  return min;
 }
}
