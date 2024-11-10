package array.n2483MinimumPenaltyForAShop;

class Solution {
 public int bestClosingTime(String customers) {
  char[] line = customers.toCharArray();
  int n = line.length;
  int leftPenalty = 0;


  for(int hour =0; hour <= n -1; hour++){
   if(line[hour] == 'N'){
    leftPenalty++;
   }
  }

  int rightPenalty = 0;
  int minPenalty = leftPenalty+rightPenalty;
  int minCloseHour = n;
  int closeCandidate=n -1;

  while(closeCandidate >=0){
   char customer = line[closeCandidate];
   leftPenalty-= customer == 'N' ? 1 :0;
   rightPenalty+= customer == 'Y' ? 1 :0;
   if(leftPenalty+ rightPenalty <= minPenalty){
    minCloseHour = closeCandidate;
    minPenalty = leftPenalty+ rightPenalty;
   }
   closeCandidate--;
  }

  return minCloseHour;
 }
}