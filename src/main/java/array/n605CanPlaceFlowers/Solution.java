package array.n605CanPlaceFlowers;

public class Solution {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {

    int left = n;

    int lastNonEmpty = -2;
    for (int place = 0; place < flowerbed.length; place++) {
      if (flowerbed[place] == 1) {
        lastNonEmpty = place;
        continue;
      }

      if ((place == flowerbed.length - 1 && place - lastNonEmpty > 1)
          || (place < flowerbed.length - 1 && place - lastNonEmpty > 1
          && flowerbed[place + 1] != 1)) {
        left--;
        lastNonEmpty = place;
      }

    }

    return left <= 0;
  }
}