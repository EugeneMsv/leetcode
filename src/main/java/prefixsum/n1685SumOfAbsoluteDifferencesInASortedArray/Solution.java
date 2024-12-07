package prefixsum.n1685SumOfAbsoluteDifferencesInASortedArray;

class Solution {
 public int[] getSumAbsoluteDifferences(int[] nums) {
  int n =  nums.length;
  int[] prefixSum=  new int[n];

  int sum = 0;
  for(int i = 0; i < n; i++){
   sum+=nums[i];
   prefixSum[i] = sum;
  }

  for(int i = 0; i < n; i++){
   nums[i] = i*nums[i]- ( i==0 ? 0 :prefixSum[i-1])
       + prefixSum[n-1] - prefixSum[i]-(n-1-i)*nums[i];
  }


  return nums;
 }
}
