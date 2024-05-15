package bitmanipulation.n231PowerOfTwo;

class Solution {

  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }

    int count = 0;
    for (int position = 0; position < 32; position++) {
      if (getBit(n, position) == 1) {
        count++;
        if (count > 1) {
          return false;
        }
      }
    }
    return true;
  }

  private int getBit(int value, int position) {
    return (value >> position) & 1;
  }
}