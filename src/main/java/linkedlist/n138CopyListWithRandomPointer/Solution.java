package linkedlist.n138CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    int startingIndex = 10_000;

    int originalIdx = startingIndex + 1;
    Node original = head;

    Node copy = null;
    Node prevCopy = null;
    Map<Integer, Node> idxToCopy = new HashMap<>();
    while (original != null) {
      copy = new Node(original.val);
      if (prevCopy != null) {
        prevCopy.next = copy;
      }
      idxToCopy.put(originalIdx, copy);

      prevCopy = copy;
      original.val = originalIdx;
      originalIdx++;
      original = original.next;
    }

    original = head;
    while (original != null) {
      copy = idxToCopy.get(original.val);
      if (original.random != null) {
        Node copyRandom = idxToCopy.get(original.random.val);
        copy.random = copyRandom;
      }
      original = original.next;
    }
    return idxToCopy.get(startingIndex + 1);
  }
}
