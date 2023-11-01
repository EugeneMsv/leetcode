package linkedlist.n143ReorderList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */

// Solution 0 <- 1 <- 2 <- 3 <- 4(midIdx) <- 5 -> 6 -> 7
// 0 <- 7 <- 1 <- 6 <- 2 <- 5 <- 3 <- 4
// 0 -> 7 -> 1 -> 6 -> 2 -> 5 -> 3 -> 4
// Calc size, find a mid node and reverse first half, then 2 pointers add from left to right
// Reverse everything back
public class Solution {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public void reorderList(ListNode head) {

    int size = 0;
    ListNode sizeNode = head;
    while (sizeNode != null) {
      size++;
      sizeNode = sizeNode.next;
    }

    int midNodeIdx = size / 2 + (size % 2);
    // System.out.println("midNodeIdx="+midNodeIdx);
    ListNode node = head;
    ListNode prevNode = null;
    int idx = 1;
    while (idx <= midNodeIdx) {
      ListNode nextNode = node.next;
      node.next = prevNode;
      prevNode = node;
      node = nextNode;
      idx++;
    }

    ListNode rightNode = node;
    ListNode reversedNode = prevNode;
    ListNode reversedHead = prevNode;
    if (size % 2 == 0) {
      ListNode tempRight = rightNode;
      rightNode = rightNode.next;
      tempRight.next = reversedNode;
      reversedHead = tempRight;
    }
    // System.out.println("rightNode="+rightNode.val);
    // System.out.println("reversedNode="+reversedNode.val);
    while (rightNode != null) {
      ListNode tempReverse = reversedNode.next;
      ListNode tempRight = rightNode.next;
      reversedNode.next = rightNode;
      rightNode.next = tempReverse;
      rightNode = tempRight;
      reversedNode = tempReverse;
    }

    reverse(reversedHead);

  }

  private void reverse(ListNode reversedHead) {
    ListNode node = reversedHead;
    ListNode prevNode = null;
    while (node != null) {
      ListNode nextNode = node.next;
      node.next = prevNode;
      prevNode = node;
      node = nextNode;
    }
  }
}
