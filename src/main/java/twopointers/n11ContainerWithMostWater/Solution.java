package twopointers.n11ContainerWithMostWater;

public class Solution {

  public int maxArea(int[] height) {

    int maxSquare = 0;
    int left = 0;
    int right = height.length - 1;
    while (right > left) {
      int leftHeight = height[left];
      int rightHeight = height[right];
      int square = (right - left) * Math.min(leftHeight, rightHeight);
      maxSquare = Math.max(maxSquare, square);
      if (leftHeight <= rightHeight) {
        left++;
      } else {
        right--;
      }
    }
    return maxSquare;
  }
}
