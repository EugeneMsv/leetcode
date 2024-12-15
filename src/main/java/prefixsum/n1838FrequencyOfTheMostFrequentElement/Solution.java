package prefixsum.n1838FrequencyOfTheMostFrequentElement;

import java.util.Arrays;

class Solution {
 public int maxFrequency(int[] nums, int k) {
  Arrays.sort(nums);

  int n =  nums.length;
  long[] prefixSum =  new long[n];

  long sum = 0;
  for(int i =0; i < n; i++){
   sum+=nums[i];
   prefixSum[i]=sum;
  }

  int max = 1;
  for(int i = n-1; i >0; i--){
   max = Math.max(max, maxFreqPerNum(prefixSum, i, nums[i],k));
  }

  return max;

 }

 private int maxFreqPerNum(long[] prefixSum, int numIdx, int num, long k){
  if((long)num*(numIdx+1) <=prefixSum[numIdx]+k){
   return numIdx+1;
  }
  int left = 0;
  int right =numIdx-1;

  while(left < right){
   int pivotIdx =  left+ (right-left)/2;
   long toMatch = (numIdx - pivotIdx)* (long)num;
   long pivotResult = prefixSum[numIdx] - prefixSum[pivotIdx] +k;
   if(toMatch <= pivotResult){
    right = pivotIdx;
   }else{
    left = pivotIdx+1;
   }

  }
  return numIdx -left;
 }
}