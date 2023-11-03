package binarysearch.n981TimeBasedKVStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

  private final Map<String, List<Node>> map;

  public TimeMap() {
    map = new HashMap<>();

  }

  public void set(String key, String value, int timestamp) {
    List<Node> nodes = map.get(key);
    if (nodes == null) {
      nodes = new ArrayList<>();
      map.put(key, nodes);
    }
    nodes.add(new Node(value, timestamp));
  }

  public String get(String key, int timestamp) {
    List<Node> nodes = map.get(key);
    if (nodes == null) {
      return "";
    }

    Node result = binarySearch(nodes, timestamp);
    return result == null ? "" : result.value;
  }

  private Node binarySearch(List<Node> nodes, int timestamp) {
    int begin = 0;
    int end = nodes.size() - 1;

    while (begin <= end) {
      if (end - begin <= 1) {
        return nodes.get(end).timestamp <= timestamp ? nodes.get(end)
            : nodes.get(begin).timestamp <= timestamp ? nodes.get(begin)
                : null;
      }

      int pivot = (begin + end) / 2;
      Node pivotNode = nodes.get(pivot);
      if (pivotNode.timestamp > timestamp) {
        end = pivot;
      } else if (pivotNode.timestamp < timestamp) {
        begin = pivot;
      } else {
        return pivotNode;
      }
    }
    return null;
  }

  private class Node {

    private final String value;
    private final int timestamp;

    Node(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }

  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp); String param_2 = obj.get(key,timestamp);
 */