package array.n2348NumberOfZeroFilledSubarrays;

class Solution {
 public long zeroFilledSubarray(int[] nums) {
  long sum =0;
  long zeros =0;
  long localSum =0;
  for(int num : nums){
   if(num ==0 ){
    zeros++;
    localSum+=zeros;
   } else{
    zeros=0;
    sum+=localSum;
    localSum=0;
   }

  }
  sum+=localSum;

  return sum;
 }
}
