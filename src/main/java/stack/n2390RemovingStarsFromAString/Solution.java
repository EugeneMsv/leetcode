package stack.n2390RemovingStarsFromAString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

  public String removeStars(String s) {

    return removeStarsSb(s);
  }

  public String removeStarsList(String s) {

    int theLastChar = 0;

    List<Character> chars = new ArrayList<>(s.length());
    chars.add(theLastChar, s.charAt(theLastChar));

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '*') {
        theLastChar--;
      } else {
        chars.add(++theLastChar, c);
      }
    }

    return chars.stream()
        .limit(theLastChar >= 0 ? theLastChar + 1 : 0)
        .map(String::valueOf)
        .collect(Collectors.joining());

  }

  public String removeStarsSb(String s) {

    int theLastChar = 0;

    StringBuilder chars = new StringBuilder();
    chars.append(s.charAt(theLastChar));

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '*') {
        theLastChar--;
      } else {
        chars.setLength(theLastChar + 2);
        chars.setCharAt(++theLastChar, c);
      }
    }

    chars.setLength(theLastChar >= 0 ? theLastChar + 1 : 0);

    return chars.toString();

  }
}