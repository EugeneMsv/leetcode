package array.n2073TimeNeededToBuyTickets;

class Solution {
 public int timeRequiredToBuy(int[] tickets, int k) {
  int kTime =  tickets[k];

  int time = 0;
  for(int i = 0; i <= (kTime == 1 ? k : tickets.length-1); i++){
   time+= Math.min(kTime, tickets[i]);
  }

  int rightBiggerThenK = 0;
  for(int i = k+1; i < tickets.length; i++){
   if(tickets[i] >= kTime){
    rightBiggerThenK++;
   }
  }
  rightBiggerThenK = kTime == 1 ? 0 : rightBiggerThenK;

  return time-rightBiggerThenK;
 }
}
