package array.n3042CountPrefixAndSuffixPairs1;

class Solution {

  public int countPrefixSuffixPairs(String[] words) {

    int count = 0;

    for (int i = 0; i < words.length; i++) {

      for (int j = i + 1; j < words.length; j++) {
        String left = words[i];
        String right = words[j];
        if (isPrefixAndSuffix(left, right)) {
          count++;
        }

      }
    }

    return count;

  }

  private boolean isPrefixAndSuffix(String left, String right) {
    if (left.length() > right.length()) {
      return false;
    }

    for (int i = 0; i < left.length(); i++) {
      char leftC = left.charAt(i);
      char prefixRight = right.charAt(i);
      char suffixRight = right.charAt(right.length() - left.length() + i);
      if (!(leftC == prefixRight && leftC == suffixRight)) {
        return false;
      }
    }

    return true;

  }

}