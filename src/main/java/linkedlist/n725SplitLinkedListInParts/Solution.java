package linkedlist.n725SplitLinkedListInParts;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution {

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

  public ListNode[] splitListToParts(ListNode head, int k) {
    int n = 0;
    ListNode node = head;
    while (node != null) {
      node = node.next;
      n++;
    }

    int rest = n % k;

    ListNode[] result = new ListNode[k];
    ListNode last = new ListNode();
    last.next = head;
    for (int i = 0; i < k; i++) {
      int expectedSize = n / k;
      if (rest > 0) {
        expectedSize++;
        rest--;
      }

      if (last == null) {
        result[i] = null;
        continue;
      }

      node = last.next;
      result[i] = node;
      last.next = null;
      int actualSize = 1;
      while (node != null && actualSize < expectedSize) {
        node = node.next;
        actualSize++;
      }
      last = node;
    }

    return result;
  }
}
