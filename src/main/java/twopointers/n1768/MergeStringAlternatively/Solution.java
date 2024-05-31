package twopointers.n1768.MergeStringAlternatively;

public class Solution {

  public String mergeAlternately(String word1, String word2) {
    char[] merged = new char[word1.length() + word2.length()];

    int w1 = 0;
    int w2 = 0;
    boolean first = true;
    int i = 0;
    while (w1 < word1.length() && w2 < word2.length()) {

      merged[i++] = first ? word1.charAt(w1++) : word2.charAt(w2++);
      first = !first;
    }
    for (int j = w1; j < word1.length(); j++) {
      merged[i] = word1.charAt(j);
      i++;
    }

    for (int j = w2; j < word2.length(); j++) {
      merged[i] = word2.charAt(j);
      i++;
    }

    return new String(merged);
  }
}
