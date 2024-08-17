package twopointers.n42TrappingRainWater;

class Solution {

  public int trap(int[] height) {

    int begin = height[0];
    int beginIdx = 0;

    int all = 0;
    int sum = 0;
    for (int i = 1; i < height.length; i++) {
      int h = height[i];
      if (begin <= h) {
        all += sum;
        begin = h;
        beginIdx = i;
        sum = 0;
        continue;
      }

      sum += (begin - h);

    }

    if (beginIdx < height.length - 1) {
      int endIdx = beginIdx;
      sum = 0;
      begin = height[height.length - 1];
      for (int i = height.length - 2; i >= endIdx; i--) {
        int h = height[i];
        if (begin <= h) {
          all += sum;
          begin = h;
          sum = 0;
          continue;
        }

        sum += (begin - h);
      }

    }

    return all;
  }
}
