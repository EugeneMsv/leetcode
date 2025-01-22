package prefixsum.n1423MaximumPointsYouCanObtainFromCards;

class Solution {
 public int maxScore(int[] cardPoints, int k) {
  int n = cardPoints.length;
  int[] prefixSum  =  new int[k];
  int[] reverseSum = new int[k];
  int sum =0;
  int rSum = 0;
  for(int i = 0; i < k; i++){
   sum+=cardPoints[i];
   rSum+=cardPoints[n-i-1];
   prefixSum[i]=sum;
   reverseSum[i]=rSum;
  }

  int left= k-1;
  int right = -1;
  int maxSum = 0;

  while(right < k){
   int leftSum = 0;
   int rightSum = 0;
   if(left>=0){
    leftSum = prefixSum[left];
   }
   left--;
   if(right>=0){
    rightSum = reverseSum[right];
   }
   right++;
   maxSum= Math.max(maxSum, rightSum+leftSum);

  }

  return maxSum;
 }
}
