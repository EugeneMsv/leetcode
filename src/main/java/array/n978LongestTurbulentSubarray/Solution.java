package array.n978LongestTurbulentSubarray;

class Solution {

 static enum Sign {
  LESS,
  GREATER;

  public boolean match(int left, int right){
   if( this == LESS){
    return right < left;
   }else {
    return right > left;
   }
  }

  public static Sign getSign(int left, int right){
   return LESS.match(left, right)
       ? LESS
       : GREATER.match(left, right)
           ? GREATER
           : null;
  }

  public Sign next(){
   return this ==  LESS ? GREATER : LESS;
  }
 }

 public int maxTurbulenceSize(int[] nums) {
  if(nums.length == 1){
   return nums.length;
  }

  Sign sign = null;
  int length = 1;
  int max = length;

  for(int i = 1; i < nums.length; i++){
   int left = nums[i-1];
   int right = nums[i];
   if(sign == null){
    sign =  Sign.getSign(left, right);
    length = sign == null ? 1 :2;
    max =  Math.max(max, length);
    continue;
   }
   if( sign.next().match(left,right) ){
    length++;
    sign =  sign.next();
   } else if (sign.match(left, right)) {
    length = 2;
   }else{
    length = 1;
    sign = null;
   }
   max =  Math.max(max, length);

  }
  return max;
 }


}