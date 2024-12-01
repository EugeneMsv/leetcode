package slidingwindow.n904FruitIntoBaskets;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public int totalFruit(int[] fruits) {
    int n = fruits.length;
    if (n == 1 || n == 2) {
      return n;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int left = 0;
    int right = 0;

    while (right < n) {
      int fruit = fruits[right];
      map.put(fruit, map.getOrDefault(fruit, 0) + 1);

      while (left < right && map.size() > 2) {
        int leftFruit = fruits[left];
        Integer leftCount = map.get(leftFruit);
        if (leftCount > 1) {
          map.put(leftFruit, leftCount - 1);
        } else {
          map.remove(leftFruit);
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
      right++;

    }
    return max;
  }

}
