package math.n66PlusOne;

public class Solution {

  public int[] plusOne(int[] digits) {
    int end = digits.length - 1;
    if (digits[end] != 9) {
      digits[end] += 1;
      return digits;
    } else {
      int ninesCount = 0;

      for (int digit : digits) {
        if (digit == 9) {
          ninesCount++;
        }
      }

      if (ninesCount == digits.length) {
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
      }

      while (end >= 0 && digits[end] == 9) {
        digits[end] = 0;
        end--;
      }
      digits[end] += 1;
      return digits;
    }
  }
}
