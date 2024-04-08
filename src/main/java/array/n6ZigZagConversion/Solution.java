package array.n6ZigZagConversion;

public class Solution {

  public String convert(String s, int numRows) {
    if (s.length() == 0 || s.length() == 1) {
      return s;
    }
    if (numRows == 1) {
      return s;
    }
    int n = numRows;
    int m = s.length() / (2 * n - 1) + 1;

    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < numRows; row++) {
      if (row >= s.length()) {
        break;
      }
      if (row == 0 || row == numRows - 1) {
        int start = row;
        Character c = s.charAt(start);
        while (c != null) {
          sb.append(c);
          c = nextStraightChar(s, start, n);
          start = nextStraightIdx(start, n);

        }
      } else {
        int start = row;
        Character c = s.charAt(start);
        while (c != null) {
          sb.append(c);

          // Do Zizag char
          c = nextZigZagChar(s, start, n, row);
          if (c == null) {
            break;
          }
          sb.append(c);

          // Do straight char
          c = nextStraightChar(s, start, n);
          start = nextStraightIdx(start, n);

        }
      }

    }

    return sb.toString();
  }

  private Character nextZigZagChar(String s, int startFrom, int n, int currentRow) {
    int idx = startFrom + 2 * (n - currentRow) - 2;
    return idx < s.length() ? s.charAt(idx) : null;
  }

  private int nextStraightIdx(int startFrom, int n) {
    return startFrom + 2 * n - 2;
  }

  private Character nextStraightChar(String s, int startFrom, int n) {
    int idx = nextStraightIdx(startFrom, n);
    return idx < s.length() ? s.charAt(idx) : null;
  }
}
