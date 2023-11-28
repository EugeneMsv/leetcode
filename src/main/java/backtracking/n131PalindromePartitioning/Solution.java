package backtracking.n131PalindromePartitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new LinkedList<>();
    backtrack(result, new ArrayList<>(s.length()), s, 0);

    return result;
  }

  private void backtrack(List<List<String>> result, List<String> variant, String s, int start) {
    if (start >= s.length()) {
      result.add(new ArrayList<>(variant));
      return;
    }

    for (int subLength = 1; subLength <= s.length() - start; subLength++) {
      if (isPalindrome(s, start, start + subLength)) {
        variant.add(s.substring(start, start + subLength));
        backtrack(result, variant, s, start + subLength);
        variant.remove(variant.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    int left = start;
    int right = end - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}