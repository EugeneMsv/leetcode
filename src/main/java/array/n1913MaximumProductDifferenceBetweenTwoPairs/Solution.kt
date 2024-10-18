package array.n1913MaximumProductDifferenceBetweenTwoPairs


class Solution {
 fun maxProductDifference(nums: IntArray): Int {
  var max1 =0


  var min1 =0


  for(i in 0 until nums.size){
   max1 = if(nums[i] >= nums[max1]) i else max1
   min1 = if(nums[i] <= nums[min1]) i else min1
  }

  var max2 = if (max1 == 0) 1 else 0
  var min2 = if (min1 == 0) 1 else 0

  for(i in 0 until nums.size){
   max2 = if( i!= max1 && nums[i] >= nums[max2]) i else max2
   min2 = if(i!= min1 && nums[i] <= nums[min2]) i else min2
  }
  // println("max1=$max1, max2=$max2, min1=$min1 ,min2=$min2")
  return nums[max1]*nums[max2] - nums[min1]*nums[min2]
 }
}