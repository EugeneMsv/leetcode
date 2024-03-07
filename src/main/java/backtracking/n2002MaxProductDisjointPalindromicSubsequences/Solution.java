package backtracking.n2002MaxProductDisjointPalindromicSubsequences;

public class Solution {

  int max = 0;

  public int maxProduct(String s) {

    dfs(s.toCharArray(), 0, "", "");

    return max;
  }

  public void dfs(char[] chars, int charNum, String s1, String s2) {

    if (charNum >= chars.length) {

      if (isPalindrome(s1) && isPalindrome(s2)) {
        max = Math.max(max, s1.length() * s2.length());
      }
      return;
    }

    // Just checking all the cases if we consider letter to first or second string
    dfs(chars, charNum + 1, s1 + chars[charNum], s2);
    dfs(chars, charNum + 1, s1, s2 + chars[charNum]);
    dfs(chars, charNum + 1, s1, s2);
  }

  public boolean isPalindrome(String str) {

    int i = 0, j = str.length() - 1;

    while (i < j) {

      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }
}

