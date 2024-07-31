package string.n459RepeatedSubstringPattern;

class Solution {

  public boolean repeatedSubstringPattern(String s) {

    int subEnd = s.length() / 2;

    while (subEnd > 0) {
      if (s.length() % subEnd == 0) {
        String subStr = s.substring(0, subEnd);
        String repeated = "";
        for (int i = 1; i <= s.length() / subEnd; i++) {
          repeated += subStr;
        }
        if (repeated.equals(s)) {
          return true;
        }
      }
      subEnd--;
    }

    return false;
  }
}
