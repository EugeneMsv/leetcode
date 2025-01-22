package twopointers.n1750MinimumLengthOfStringAfterDeletingSimilarEnds;

class Solution {
 public int minimumLength(String s) {
  int n  = s.length();
  if(n<=1){
   return n;
  }
  char[] chars =  s.toCharArray();
  boolean removed =  true;
  int left = 0;
  int right = n-1;

  while(left < right && removed){
   removed = false;
   int leftCandidate  = left;
   char letter = chars[leftCandidate];
   while(chars[leftCandidate] == letter && leftCandidate < right){
    leftCandidate++;
   }
   while(chars[right] == letter && right >= leftCandidate){
    right--;
    removed = true;
   }
   if(removed){
    left = leftCandidate;
   }
  }

  return right >= left ? right-left +1 : 0;
 }
}
