package slidingwindow.n1456MaxNumberOfVowelsInSubstring;

import java.util.Set;

class Solution {

  private static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

  public int maxVowels(String s, int k) {

    int left = 0;
    int right = k - 1;

    int count = 0;

    for (int i = left; i <= right; i++) {
      count += vowels.contains(s.charAt(i)) ? 1 : 0;
    }
    int max = count;
    while (right + 1 < s.length()) {

      Character toRemove = s.charAt(left++);
      Character toAdd = s.charAt(++right);
      count -= vowels.contains(toRemove) ? 1 : 0;
      count += vowels.contains(toAdd) ? 1 : 0;

      max = Math.max(max, count);

    }

    return max;

  }
}
