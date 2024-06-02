package array.n1431KidsWithGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = Integer.MIN_VALUE;

    for (int candy : candies) {
      max = Math.max(max, candy);
    }

    List<Boolean> result = new ArrayList<>(candies.length);

    for (int kid = 0; kid < candies.length; kid++) {
      result.add(candies[kid] >= max - extraCandies);
    }
    return result;
  }
}