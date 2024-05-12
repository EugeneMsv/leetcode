package bitmanipulation.n260SingleNumber3;

public class Solution {

  public int[] singleNumber(int[] nums) {

    int[] bitCount = new int[32];
    int twoXor = 0;
    for (int num : nums) {
      for (int position = 0; position < 32; position++) {
        int bit = getBit(num, position);
        if (bit == 1) {
          bitCount[position] += 1;
        }
      }
      twoXor = num ^ twoXor;
    }

    int weirdPosition = -1;
    for (int position = 0; position < 32; position++) {
      if (bitCount[position] % 2 != 0) {
        weirdPosition = position;
        break;
      }
    }

    int weirdXor = 0;
    for (int num : nums) {
      if (getBit(num, weirdPosition) == 1) {
        weirdXor = weirdXor ^ num;
      }
    }

    return new int[]{weirdXor, twoXor ^ weirdXor};

  }

  private int getBit(int value, int position) {
    return (value >> position) & 1;
  }
}
