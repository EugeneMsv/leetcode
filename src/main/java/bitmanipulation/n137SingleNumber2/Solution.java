package bitmanipulation.n137SingleNumber2;

public class Solution {
 // Continuation of xor,  when we see 3 times than drop the counter. Bucket 1 and bucket 2 used as counters
 public int singleNumber(int[] nums) {
  int bucket1 = 0 ;
  int bucket2 = 0 ;

  for(int num: nums){
   for(int bitPosition = 0; bitPosition < 32; bitPosition++){
    int bitValue = getBit(num, bitPosition);
    if(bitValue == 0){
     continue;
    }

    int metOnce = getBit(bucket1, bitPosition);
    if(metOnce == 1){
     int metTwice = getBit(bucket2, bitPosition);
     if(metTwice == 1){
      bucket1= setBitToZero(bucket1, bitPosition);
      bucket2= setBitToZero(bucket2, bitPosition);
     } else{
      bucket2= setBitToOne(bucket2, bitPosition);
     }

    }
    else {
     bucket1= setBitToOne(bucket1, bitPosition);
    }

   }
  }

  return bucket1;
 }

 private int getBit(int value, int position){
  return (value >> position)  & 1;
 }

 private int setBitToOne(int value, int position){
  return ( 1 << position) | value;
 }

 private int setBitToZero(int value, int position){
  return ~( 1 << position) & value;
 }
}
