package binarysearch.n367ValidPerfectSquare;

class Solution {
 public boolean isPerfectSquare(int num) {

  int left =  1;
  int right = 50_000;

  while(left < right){
   int pivot = left+ (right-left)/2;
   int square = pivot*pivot;
   if( square == num){
    return true;
   }
   if( num > square && square >0){
    left= pivot+1;
   }else{
    right=pivot;
   }
  }
  return left*left == num;
 }
}