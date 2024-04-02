package hashing.n380InsertDeleteRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

  private final List<Integer> list = new ArrayList<>();

  private final Map<Integer, Integer> map = new HashMap<>();

  private final Random random = new Random();

  public RandomizedSet() {

  }

  public boolean insert(int val) {
    Integer listIdx = map.get(val);
    if (listIdx == null) {
      list.add(val);
      map.put(val, list.size() - 1);
      return true;
    }
    return false;
  }

  public boolean remove(int val) {
    Integer listIdx = map.get(val);
    if (listIdx != null) {
      //swap with the last one
      int size = list.size();
      if (listIdx != size - 1) {
        int lastValue = list.get(size - 1);
        list.set(listIdx, lastValue);
        map.put(lastValue, listIdx);
      }
      list.remove(size - 1);
      map.remove(val);
      return true;
    }
    return false;

  }

  public int getRandom() {
    int idx = random.nextInt(list.size());
    return list.get(idx);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
