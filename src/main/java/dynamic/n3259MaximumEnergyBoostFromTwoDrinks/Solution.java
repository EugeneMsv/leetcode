package dynamic.n3259MaximumEnergyBoostFromTwoDrinks;

class Solution {
 public long maxEnergyBoost(int[] a, int[] b) {
  int n = a.length;
  long[] dpA=  new long[n];
  long[] dpB =  new long[n];
  dpA[0] = a[0];
  dpB[0] = b[0];
  dpA[1] = dpA[0]+ a[1];
  dpB[1] = dpB[0]+ b[1];

  for(int i =2; i< n; i++){
   dpA[i] = Math.max(dpA[i-1],dpB[i-2])+a[i];
   dpB[i] = Math.max(dpB[i-1],dpA[i-2])+b[i];
  }

  return Math.max(dpA[n-1], dpB[n-1]);
 }
}