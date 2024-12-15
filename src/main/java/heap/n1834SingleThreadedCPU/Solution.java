package heap.n1834SingleThreadedCPU;

import java.util.PriorityQueue;

class Solution {
 public int[] getOrder(int[][] tasks) {

  PriorityQueue<Node> pq =  new PriorityQueue<Node>();

  PriorityQueue<Node>  pqReady =  new PriorityQueue<Node>((a,b) ->
      a.duration != b.duration
          ? a.duration - b.duration
          : a.index - b.index
  );

  for(int i =0; i < tasks.length;  i++){
   pq.offer(new Node(tasks[i][0], tasks[i][1],i));
  }

  int currentTime =pq.peek().startTime;
  int resultIdx = 0;
  int[] result = new int[tasks.length];
  while(!pq.isEmpty() || !pqReady.isEmpty()){

   if(!pq.isEmpty() &&  pqReady.isEmpty() && pq.peek().startTime > currentTime){
    currentTime = pq.peek().startTime;
   }

   while(!pq.isEmpty() && pq.peek().startTime <= currentTime){
    Node ready = pq.poll();
    pqReady.offer(ready);
   }

   Node toExecute = pqReady.poll();
   result[resultIdx] = toExecute.index;
   resultIdx++;
   currentTime += toExecute.duration;

  }
  return result;
 }

 private class Node implements Comparable<Node>{
  int startTime;
  int duration;
  int index;

  Node(int startTime, int duration, int index){
   this.startTime =  startTime;
   this.duration =  duration;
   this.index =  index;
  }



  public int compareTo(Node other) {
   return startTime != other.startTime
       ? startTime - other.startTime
       : duration != other.duration
           ? duration - other.duration
           : index - other.index;
  }


  public String toString(){
   return "[startTime=%s, duration=%s, index=%s]".formatted(startTime, duration, index);
  }

 }
}
