package twopointers.n345ReverseVowelsOfAString;

import java.util.Set;

public class Solution {

  static Set<Character> vowels = Set.of('A', 'a', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

  public String reverseVowels(String s) {

    int left = 0;
    int right = s.length() - 1;

    char[] result = new char[s.length()];
    while (left < right) {
      char leftC = s.charAt(left);
      if (!vowels.contains(leftC)) {
        result[left] = leftC;
        left++;
        continue;
      }
      char rightC = s.charAt(right);
      if (!vowels.contains(rightC)) {
        result[right] = rightC;
        right--;
        continue;
      }

      result[left] = rightC;
      result[right] = leftC;
      left++;
      right--;
    }
   if (right == left) {
    result[left] = s.charAt(left);
   }
    return new String(result);
  }
}
