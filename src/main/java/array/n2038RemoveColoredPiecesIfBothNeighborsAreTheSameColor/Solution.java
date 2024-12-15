package array.n2038RemoveColoredPiecesIfBothNeighborsAreTheSameColor;

class Solution {

  public boolean winnerOfGame(String colors) {
    if (colors.length() <= 2) {
      return false;
    }

    int aTriplets = 0;
    int bTriplets = 0;
    char[] chars = colors.toCharArray();
    for (int i = 2; i < chars.length; i++) {
      if (isTriplet(chars, i, 'A')) {
        aTriplets++;
      }
      if (isTriplet(chars, i, 'B')) {
        bTriplets++;
      }
    }
    return aTriplets > bTriplets;
  }

  private boolean isTriplet(char[] chars, int end, char target) {
    for (int i = end - 2; i <= end; i++) {
      if (chars[i] != target) {
        return false;
      }
    }

    return true;
  }
}