package math.n43MultiplyStrings;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public String multiply(String num1, String num2) {
    char[] a = num1.toCharArray();
    char[] b = num2.toCharArray();

    List<Integer> sum = new LinkedList<>();
    List<Integer> m = new LinkedList<>();

    for (int bIdx = b.length - 1; bIdx >= 0; bIdx--) {
      m.clear();
      int rest = 0;
      int bDigit = toDigit(b[bIdx]);
      int zerosCount = 0;
      for (int aIdx = a.length - 1; aIdx >= 0; aIdx--) {
        int aDigit = toDigit(a[aIdx]);
        int multiplication = aDigit * bDigit + rest;
        m.add(0, multiplication % 10);
        rest = multiplication / 10;
        if (multiplication % 10 == 0) {
          zerosCount++;
        }
      }
      if (rest > 0) {
        m.add(0, rest);
      }

      if (zerosCount == m.size()) {
        m.clear();
        m.add(0);
      } else {
        for (int i = bIdx; i < b.length - 1; i++) {
          m.add(0);
        }
      }
      sum = calcSum(sum, m);
    }

    return sum.stream().map(String::valueOf).collect(Collectors.joining());
  }

  private int toDigit(char c) {
    return Integer.parseInt(String.valueOf(c));
  }

  private List<Integer> calcSum(List<Integer> left, List<Integer> right) {
    int i = left.size() - 1;
    int j = right.size() - 1;

    int overflow = 0;
    List<Integer> result = new LinkedList<>();
    while (i >= 0 && j >= 0) {
      int sum = left.get(i) + right.get(j) + overflow;
      result.add(0, sum % 10);
      overflow = sum / 10;
      i--;
      j--;
    }
    for (int k = i; k >= 0; k--) {
      result.add(0, (left.get(k) + overflow) % 10);
      overflow = (left.get(k) + overflow) / 10;
    }

    for (int k = j; k >= 0; k--) {
      result.add(0, (right.get(k) + overflow) % 10);
      overflow = (right.get(k) + overflow) / 10;
    }
    if (overflow > 0) {
      result.add(0, overflow);
    }
    return result;
  }

}
