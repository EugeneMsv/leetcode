package backtracking.n17LetterOnPhoneNumber;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

  private static final Map<Character, List<Character>> DICT = Map.of(
      '2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'),
      '4', List.of('g', 'h', 'i'),
      '5', List.of('j', 'k', 'l'),
      '6', List.of('m', 'n', 'o'),
      '7', List.of('p', 'q', 'r', 's'),
      '8', List.of('t', 'u', 'v'),
      '9', List.of('w', 'x', 'y', 'z')
  );

  public List<String> letterCombinations(String digits) {
    List<String> results = new LinkedList<>();
    backtrack(results, new char[digits.length()], 0, digits, 0);
    return results;
  }

  private void backtrack(List<String> results, char[] variant, int variantStart, String digits,
      int start) {
    if (start >= digits.length()) {
      if (start > 0) {
        results.add(new String(variant));
      }
      return;
    }

    char digit = digits.charAt(start);
    for (Character letter : DICT.get(digit)) {
      variant[variantStart] = letter;
      backtrack(results, variant, variantStart + 1, digits, start + 1);
      variant[variantStart] = '-';
    }
  }
}
