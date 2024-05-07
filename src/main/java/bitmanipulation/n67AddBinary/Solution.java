package bitmanipulation.n67AddBinary;

public class Solution {

  public String addBinary(String a, String b) {
    int bIdx = b.length() - 1;
    int aIdx = a.length() - 1;
    char[] result = new char[Math.max(a.length(), b.length()) + 1];
    int carry = 0;
    int resultIdx = result.length - 1;
    while (bIdx >= 0 || aIdx >= 0) {
      int ai = aIdx >= 0 ? Character.getNumericValue(a.charAt(aIdx)) : 0;
      int bi = bIdx >= 0 ? Character.getNumericValue(b.charAt(bIdx)) : 0;
      int sum = sum(sum(ai, bi), carry);
      // System.out.println("ai=%s, bi=%s, carry=%s, sum=%s".formatted(ai, bi, carry, sum));
      result[resultIdx] = Character.forDigit(sum & 1, 10);
      carry = (sum >> 1) & 1;

      bIdx--;
      aIdx--;
      resultIdx--;
    }
    result[resultIdx] = Character.forDigit(carry, 10);
    if (carry == 0) {
      return new String(result).substring(1);
    }
    return new String(result);
  }

  private int sum(int p, int q) {
    int carry = (p & q) << 1;
    if (carry != 0) {
      return sum(p ^ q, carry);
    }
    return p ^ q;
  }
}
