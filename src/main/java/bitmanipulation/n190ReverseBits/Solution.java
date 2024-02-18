package bitmanipulation.n190ReverseBits;

public class Solution {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {

    long reversed = 0;
    for (int bit = 0; bit < 32; bit++) {
      int bitValue = (n >>> bit) & 1;
      if (bitValue == 1) {
        reversed += Math.pow(2, 31 - bit);
      }

    }
    return (int) reversed;

  }
}
