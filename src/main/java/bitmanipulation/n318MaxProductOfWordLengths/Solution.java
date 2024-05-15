package bitmanipulation.n318MaxProductOfWordLengths;

class Solution {

  public int maxProduct(String[] words) {
    int[] freq = new int[words.length];

    for (int i = 0; i < words.length; i++) {
      int frequency = 0;
      for (char c : words[i].toCharArray()) {
        int position = (int) c - (int) 'a';
        frequency = setBitToOne(frequency, position);
      }
      freq[i] = frequency;
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < words.length; i++) {
      int freqI = freq[i];
      for (int j = i + 1; j < words.length; j++) {
        int freqJ = freq[j];

        if ((freqI & freqJ) == 0) {

          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max == Integer.MIN_VALUE ? 0 : max;
  }

  private int setBitToOne(int value, int position) {
    return getBit(value, position) == 0 ? (1 << position) | value
        : value;
  }

  private int getBit(int value, int position) {
    return (value >> position) & 1;
  }

}
