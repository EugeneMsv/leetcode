package math.n2028FindMissingObservations;

class Solution {
 public int[] missingRolls(int[] rolls, int mean, int n) {
  int mSum = 0;
  int m = rolls.length;
  for(int roll: rolls){
   mSum+=roll;
  }
  int nSum = mean*(n+m) - mSum;

  if(nSum< n || nSum > 6*n){
   return new int[]{};
  }
  int[] result = new int[n];
  for(int i =0; i <n; i++){
   int el =  nSum/(n-i) + (nSum % (n-i) == 0 ? 0 : 1);
   nSum-=el;
   result[i]=el;
  }

  return result;
 }
}
