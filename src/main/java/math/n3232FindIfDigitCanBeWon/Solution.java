package math.n3232FindIfDigitCanBeWon;

class Solution {

  public boolean canAliceWin(int[] nums) {

    int singleSum = 0;
    int doubleSum = 0;

    for (int num : nums) {
      if (num >= 10) {
        doubleSum += num;
      } else {
        singleSum += num;
      }
    }

    return singleSum != doubleSum;
  }
}
