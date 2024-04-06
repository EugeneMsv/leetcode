package array.n151ReverseWordsInString;

public class Solution {

  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    int idx = s.length() - 1;
    StringBuilder wordAccumulator = new StringBuilder();

    while (idx >= 0) {
      if (s.charAt(idx) == ' ') {
        addReversedWord(sb, wordAccumulator);

        while (idx >= 0 && s.charAt(idx) == ' ') {
          idx--;
        }
        if (idx < 0) {
          break;
        }
      }

      wordAccumulator.append(s.charAt(idx));
      idx--;
    }

    if (!wordAccumulator.isEmpty()) {
      addReversedWord(sb, wordAccumulator);
    }

    return sb.toString();
  }

  private void addReversedWord(StringBuilder sb, StringBuilder wordAccumulator) {
    if (!sb.isEmpty()) {
      wordAccumulator.append(' ');
    }
    wordAccumulator.reverse();
    sb.append(wordAccumulator);
    wordAccumulator.setLength(0);
  }

}
