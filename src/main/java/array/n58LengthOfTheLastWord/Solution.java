package array.n58LengthOfTheLastWord;

public class Solution {

  public int lengthOfLastWord(String s) {

    Integer start = null;
    Integer end = null;

    int idx = s.length() - 1;
    while (end == null && idx >= 0) {
      char c = s.charAt(idx);
      if (start != null && end == null && c == ' ') {
        end = idx;
      }
      if (start == null && c != ' ') {
        start = idx;
      }
      idx--;
    }

    return end == null ? start + 1 : start - end;
  }
}