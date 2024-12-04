package array.n189RotateArray;

class Solution {
 public void rotate(int[] nums, int k) {
  int n =  nums.length;
  int count = 0;
  int i = 0;

  while( i < k && count < n){
   int curIdx = i;
   int curValue = nums[i];

   do{
    int nextIdx = (curIdx + k) % n;
    int nextValue= nums[nextIdx];
    nums[nextIdx] = curValue;
    curValue = nextValue;
    curIdx = nextIdx;
    count++;
   } while(curIdx != i);

   i++;
  }

 }
}
