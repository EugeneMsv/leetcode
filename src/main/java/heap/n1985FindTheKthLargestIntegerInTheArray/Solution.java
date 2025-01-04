package heap.n1985FindTheKthLargestIntegerInTheArray;

import java.util.PriorityQueue;

class Solution {
 public String kthLargestNumber(String[] nums, int k) {
  PriorityQueue<String> pq =  new PriorityQueue<>((a, b) -> {
   if(b.length() != a.length()){
    return b.length()- a.length();
   }else{
    for(int i = 0; i < b.length(); i++){
     int aI = Character.getNumericValue(a.charAt(i));
     int bI = Character.getNumericValue(b.charAt(i));
     if(aI != bI){
      return bI-aI;
     }
    }
    return 0;
   }
  }
  );


  for(String num: nums){
   pq.offer(num);
  }

  for(int i =  0; i<k-1;i++){
   pq.poll();
  }

  return pq.poll();
 }
}
