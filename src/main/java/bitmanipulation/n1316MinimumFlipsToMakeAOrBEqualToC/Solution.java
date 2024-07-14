package bitmanipulation.n1316MinimumFlipsToMakeAOrBEqualToC;

class Solution {

  public int minFlips(int a, int b, int c) {
    int and = a & b;
    int or = a | b;

    int flips = 0;

    for (int position = 0; position < 32; position++) {
      int cBit = getBit(c, position);
      int orBit = getBit(or, position);
      if (orBit == cBit) {
        continue;
      }

      if (cBit == 1) {
        flips += 1;
      } else {

        flips += getBit(and, position) == 1 ? 2 : 1;
      }
    }

    return flips;
  }

  private int getBit(int value, int position) {
    return (value >> position) & 1;
  }
}