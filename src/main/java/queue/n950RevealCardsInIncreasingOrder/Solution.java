package queue.n950RevealCardsInIncreasingOrder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
 public int[] deckRevealedIncreasing(int[] deck) {
  Arrays.sort(deck);

  int n =  deck.length;

  Queue<Integer> queue =  new LinkedList<>();

  for(int i = 0; i < n ; i++){
   queue.offer(i);
  }

  int[] result = new int[n];
  int i = 0;
  while(!queue.isEmpty()){

   int idx = queue.poll();
   result[idx] = deck[i];
   if(!queue.isEmpty()){
    queue.offer(queue.poll());
   }
   i++;
  }

  return result;
 }
}
