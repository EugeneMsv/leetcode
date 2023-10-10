package array.n347TopKFrequent;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    int[] buckets = new int[40001];
    for (int num : nums) {
      buckets[num + 10000] += 1;
    }

    PriorityQueue<Node> kFrequent = new PriorityQueue<>(k + 1,
        Comparator.comparingInt(Node::getFrequency));

    for (int rawNum = 0; rawNum < buckets.length; rawNum++) {
      int frequency = buckets[rawNum];
      if (frequency <= 0) {
        continue;
      }
      kFrequent.add(new Node(rawNum - 10000, frequency));
      if (kFrequent.size() > k) {
        kFrequent.poll();
      }
    }
    int[] theMostFrequent = new int[k];
    int h = 0;
    for (Node node : kFrequent) {
      theMostFrequent[h] = node.getValue();
      h++;
    }
    return theMostFrequent;
  }

  public class Node {

    int value;
    int frequency;

    public Node(int value, int frequency) {
      this.value = value;
      this.frequency = frequency;
    }

    public int getFrequency() {
      return frequency;
    }

    public int getValue() {
      return value;
    }
  }
}
