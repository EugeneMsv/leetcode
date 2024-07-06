package heap.n2336SmallestNumberInInfiniteSet;

import java.util.HashSet;
import java.util.Set;

class SmallestInfiniteSet {

  private Set<Integer> removed;

  private int smallest;

  public SmallestInfiniteSet() {
    removed = new HashSet<>();
    smallest = 1;
  }

  public int popSmallest() {

    int newSmallest = smallest + 1;
    while (removed.contains(newSmallest)) {
      newSmallest++;
    }
    int oldSmallest = smallest;
    removed.add(oldSmallest);
    smallest = newSmallest;
    return oldSmallest;

  }

  public void addBack(int num) {
    removed.remove(num);
    if (num < smallest) {
      smallest = num;
    }
  }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such: SmallestInfiniteSet obj
 * = new SmallestInfiniteSet(); int param_1 = obj.popSmallest(); obj.addBack(num);
 */