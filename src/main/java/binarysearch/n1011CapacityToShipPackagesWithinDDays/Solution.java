package binarysearch.n1011CapacityToShipPackagesWithinDDays;

class Solution {
 public int shipWithinDays(int[] weights, int days) {
  int right = 0;
  int left = 0;
  for(int weight : weights){
   left =  Math.max(left, weight);
   right+=weight;
  }

  while(left < right){
   int pivotCapacity =  left + (right-left)/2;
   int daysToComplete= completeInDays(weights, pivotCapacity);

   if(daysToComplete == days){
    right =  pivotCapacity;
   } else if( daysToComplete > days){
    left = pivotCapacity+1;
   }else{
    right =  pivotCapacity;
   }


  }
  return left;
 }


 private int completeInDays(int[] weights, int capacity){

  int i = 0;
  int days = 0;
  while(i < weights.length){

   int currentCapacity= weights[i];
   days++;
   while(i+1 < weights.length &&  currentCapacity + weights[i+1] <= capacity ){
    currentCapacity+=weights[i+1];
    i++;
   }
   i++;
  }

  return days;
 }
}
