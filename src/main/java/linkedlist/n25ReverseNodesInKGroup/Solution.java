package linkedlist.n25ReverseNodesInKGroup;

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

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1 || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode prevTail = dummy;
    ListNode slow = head;
    ListNode fast = dummy;
    int count = 0;
    while (fast != null) {
      if (count < k) {
        fast = fast.next;
        count++;
        continue;
      }
      ListNode nextHead = fast.next;
      ListNode oldHead = slow;
      ListNode newHead = reverse(oldHead, k);

      prevTail.next = newHead;
      prevTail = oldHead;
      slow = nextHead;
      fast = nextHead;
      count = 1;
    }
    if (count != 1) {
      prevTail.next = slow;
    }

    return dummy.next;
  }

  private ListNode reverse(ListNode head, int k) {
    ListNode node = head;
    int count = 1;
    ListNode prev = null;
    while (count <= k) {
      ListNode next = node.next;
      node.next = prev;
      prev = node;
      node = next;
      count++;
    }
    return prev;
  }
}
