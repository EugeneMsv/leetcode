package array.n229MajorityElement2;

import java.util.LinkedList;
import java.util.List;

class Solution {

  public List<Integer> majorityElement(int[] nums) {
    Pair pair = new Pair();

    for (int num : nums) {
      pair.add(num);
    }

    return pair.toResult(nums);
  }

  static class Pair {

    Node first;
    Node second;

    void add(int num) {
      if (first == null) {
        first = new Node(num);
        return;
      } else if (first.num == num) {
        first.freq += 1;
        return;
      } else if (second == null) {
        second = new Node(num);
        return;
      } else if (second.num == num) {
        second.freq += 1;
        return;
      } else {
        first.freq -= 1;
        second.freq -= 1;

        if (second.freq == 0) {
          second = null;
        }
        if (first.freq == 0) {
          first = second;
          second = null;
        }
      }
    }

    public List<Integer> toResult(int[] nums) {
      if (first == null && second == null) {
        return List.of();
      }

      int firstFreq = 0;
      int secondFreq = 0;

      for (int num : nums) {
        if (first != null && first.num == num) {
          firstFreq++;
        }
        if (second != null && second.num == num) {
          secondFreq++;
        }
      }

      List<Integer> result = new LinkedList<>();
      if (firstFreq > nums.length / 3) {
        result.add(first.num);
      }
      if (secondFreq > nums.length / 3) {
        result.add(second.num);
      }

      return result;
    }
  }

  static class Node {

    int num;
    int freq = 1;

    Node(int num) {
      this.num = num;
    }
  }
}