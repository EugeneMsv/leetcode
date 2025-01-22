package linkedlist.n203RemoveLinkedListElements;

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

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode node = dummy;
    ListNode prevNode = node;
    while (node != null) {

      if (node.val == val) {
        prevNode.next = node.next;
        node = node.next;
      } else {
        prevNode = node;
        node = node.next;
      }
    }

    return dummy.next;
  }
}
