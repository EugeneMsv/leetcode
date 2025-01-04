package prefixsum.n1856MaximumSubarrayMinProduct;

import java.util.Stack;

class Solution {
 public int maxSumMinProduct(int[] nums) {
  int n =  nums.length;
  long[] prefixSum =  new long[n];
  long pSum = 0L;
  for(int i = 0;  i < n; i++){
   pSum +=nums[i];
   prefixSum[i]=pSum;
  }
  int[] rightSmaller = calcRightSmaller(nums);
  int[] leftSmaller = calcLeftSmaller(nums);

  long max = Integer.MIN_VALUE;
  for(int i =0; i < n; i++){
   int right = rightSmaller[i];
   int left = leftSmaller[i];
   long sum = prefixSum[right-1]- (left == -1 ? 0 : prefixSum[left]);
   max = Math.max(nums[i]* sum, max);
  }
  return (int)(max % 1_000_000_007L);
 }

 private int[] calcRightSmaller(int[] nums){
  int[] rightSmaller = new int[nums.length];
  Stack<int[]> stack  = new Stack<>();
  for(int i = 0; i < nums.length ; i++){
   int cur =  nums[i];
   while(!stack.isEmpty() && stack.peek()[0] > cur){
    int[] el = stack.pop();
    rightSmaller[el[1]]=i;
   }
   stack.push(new int[]{cur, i});

  }
  while(!stack.isEmpty()){
   int[] el = stack.pop();
   rightSmaller[el[1]]=nums.length ;
  }
  return rightSmaller;
 }

 private int[] calcLeftSmaller(int[] nums){
  int[] leftSmaller = new int[nums.length];
  Stack<int[]> stack  = new Stack<>();
  for(int i = nums.length -1; i >=0 ; i--){
   int cur =  nums[i];
   while(!stack.isEmpty() && stack.peek()[0] > cur){
    int[] el = stack.pop();
    leftSmaller[el[1]]=i;
   }
   stack.push(new int[]{cur, i});

  }
  while(!stack.isEmpty()){
   int[] el = stack.pop();
   leftSmaller[el[1]]=-1;
  }
  return leftSmaller;
 }

}
