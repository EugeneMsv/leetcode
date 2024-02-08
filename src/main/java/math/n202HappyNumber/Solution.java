package math.n202HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public boolean isHappy(int n) {
    Set<Integer> prevNumbers = new HashSet<>();

    int num = n;

    while (num != 1) {
      int result = 0;
      for (char rawDigit : String.valueOf(num).toCharArray()) {
        int digit = Integer.parseInt(String.valueOf(rawDigit));
        result += digit * digit;
      }
      num = result;
      // Cycle
      if (prevNumbers.contains(num)) {
        return false;
      }

      prevNumbers.add(num);
    }

    return true;
  }
}
