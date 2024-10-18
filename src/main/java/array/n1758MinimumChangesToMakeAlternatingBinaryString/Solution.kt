package array.n1758MinimumChangesToMakeAlternatingBinaryString


class Solution {
 fun minOperations(s: String): Int {
  var zero = 0;
  var one = 0;

  for((i, c) in s.withIndex() ){
   if(i % 2 == 0){
    zero+= if(c == '0') 0 else 1
    one+= if(c == '1') 0 else 1
   } else {
    zero+= if(c == '1') 0 else 1
    one+= if(c == '0') 0 else 1
   }

  }

  return minOf(zero, one)

 }
}