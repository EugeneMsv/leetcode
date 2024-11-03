package array.n560SubarraySumEqualsK;

class Solution {
 public int subarraySum(int[] nums, int k) {

  int[] zeroSums  = new int[nums.length];
  int prefixSum = 0;
  int count =0;
  for(int i = 0; i < nums.length; i++){
   prefixSum+=nums[i];
   zeroSums[i]=prefixSum;
   if(prefixSum == k){
    count++;
   }
  }



  for(int from = 1; from < nums.length; from++){
   for(int to = nums.length -1; to >= from; to--){
    int sum = zeroSums[to] - zeroSums[from-1];
    if(sum == k){
     count++;
    }
   }
  }

  return count;
 }

 public int subarraySum2(int[] nums, int k) {
  int count = 0;
  for (int start = 0; start < nums.length; start++) {
   int sum=0;
   for (int end = start; end < nums.length; end++) {
    sum+=nums[end];
    if (sum == k)
     count++;
   }
  }
  return count;
 }

}