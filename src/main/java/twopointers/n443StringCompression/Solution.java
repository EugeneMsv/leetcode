package twopointers.n443StringCompression;

public class Solution {

  public int compress(char[] chars) {
    int out = 0;
    int in = 0;

    while (in < chars.length) {

      Character letter = chars[in];
      int freq = 1;
      while (in + 1 < chars.length && letter.equals(chars[in + 1])) {
        freq++;
        in++;
      }

      chars[out++] = letter;
      if (freq > 1) {
        int divider = 1000;
        boolean started = false;
        while (divider >= 1) {
          int rest = freq / divider;
          if (started || rest >= 1) {
            started = true;
            chars[out++] = Character.forDigit(rest, 10);
          }
          freq = freq % divider;
          divider /= 10;
        }
      }

      in++;
    }

    return out;
  }
}
