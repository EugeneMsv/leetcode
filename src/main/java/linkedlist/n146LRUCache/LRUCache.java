package linkedlist.n146LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private class Node {

    int value;
    int key;
    Node left;
    Node right;

    Node(Node left, int key, int value, Node right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    Node(int key, int value) {
      this.key = key;
      this.value = value;

    }

    boolean isHead() {
      return left == null;
    }

    boolean isTail() {
      return right == null;
    }

  }

  private int capacity;
  private Node head;
  private Node tail;
  private Map<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>(capacity + 1, 1.1F);

  }

  private void printList() {
    Node node = head;
    while (node != null) {
      System.out.print(
          (head == node ? " HEAD:" : "") + (tail == node ? " TAIL:" : "") + " Node(l=" + (
              node.left != null ? node.left.key : "N/A") + ", k=" + node.key + ", v=" + node.value
              + ", r=" + (node.right != null ? node.right.key : "N/A") + ") <->");
      node = node.right;
    }
    System.out.println();

  }

  public int get(int key) {

    Node existingNode = map.get(key);
    if (existingNode == null) {
      return -1;
    } else {
      moveToHead(existingNode);
      // System.out.print("After GET "+key);
      // printList();
      return existingNode.value;
    }

  }

  public void put(int key, int value) {
    Node existingNode = map.get(key);
    if (existingNode == null) {
      map.put(key, createNewHead(key, value));
      if (map.size() > capacity) {
        evictTail();
      }
    } else {
      moveToHead(existingNode);
      existingNode.value = value;
    }
    // System.out.print("After PUT {"+key+", "+value+"}");
    // printList();
  }

  private Node createNewHead(int key, int value) {
    Node newHead = new Node(null, key, value, head);
    if (head != null) {
      head.left = newHead;
    }
    head = newHead;
    if (tail == null) {
      tail = head;
    }
    return head;
  }

  private void moveToHead(Node target) {
    if (target.isHead()) {
      return;
    }
    Node left = target.left;
    if (target.isTail()) {
      left.right = null;
      tail = left;
    } else {
      Node right = target.right;
      left.right = right;
      right.left = left;
    }
    target.left = null;
    target.right = head;
    head.left = target;
    head = target;
  }

  private void evictTail() {
    map.remove(tail.key);
    if (tail.isHead()) {
      head = null;
      tail = null;
      return;
    }
    Node newTail = tail.left;
    tail.left = null;
    newTail.right = null;
    tail = newTail;
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
