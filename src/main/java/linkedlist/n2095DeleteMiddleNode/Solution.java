package linkedlist.n2095DeleteMiddleNode;

public /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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

  public ListNode deleteMiddle(ListNode head) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;
    ListNode prevSlow = new ListNode(0);

    while (fast != null) {
      prevSlow = slow;
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        fast = fast.next;
      }
    }

    prevSlow.next = slow != null ? slow.next : null;

    return dummy.next;
  }
}
