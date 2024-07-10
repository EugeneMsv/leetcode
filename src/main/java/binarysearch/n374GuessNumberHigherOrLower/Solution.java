package binarysearch.n374GuessNumberHigherOrLower;

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number 1 if num is lower than the picked number
 * otherwise return 0 int guess(int num);
 */

public class Solution extends GuessGame {

  public int guessNumber(int n) {

    int left = 1;
    int right = n;

    while (left < right) {
      int pivot = left + (right - left) / 2;
      int resultIsHigher = guess(pivot);
      if (resultIsHigher == 0) {
        return pivot;
      }
      if (resultIsHigher == 1) {
        left = pivot + 1;
      } else {
        right = pivot;
      }
    }
    return left;
  }
}
