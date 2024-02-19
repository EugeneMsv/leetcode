package bitmanipulation.n371SumOfTwoIntegers;

public class Solution {

  public int getSum(int a, int b) {
    int result = 0;
    int rest = 0;
    for (int i = 0; i < 32; i++) {
      int aBit = (a >>> i) & 1;
      int bBit = (b >>> i) & 1;
      int bit = aBit ^ bBit ^ rest;

      rest = ((aBit & bBit) == 1 || (aBit & rest) == 1
          || (bBit & rest) == 1)
          ? 1
          : 0;

      if (bit == 1) {
        result = result | (1 << i);
      }
    }

    return result;
  }

}
