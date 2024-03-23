package linkedlist.n1721SwappingNodes;

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

  public ListNode swapNodes(ListNode head, int k) {

    if (head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode endCandidate = dummy;
    int counter = 0;
    ListNode prevBegin = dummy;
    ListNode prevEnd = dummy;

    while (endCandidate != null) {
      if (counter == k - 1) {
        prevBegin = endCandidate;
      }

      if (counter > k) {
        prevEnd = prevEnd.next;
      }

      counter++;
      endCandidate = endCandidate.next;
    }

    ListNode left = prevBegin.next;
    ListNode right = prevEnd.next;
    prevBegin.next = right;
    prevEnd.next = left;
    ListNode temp = left.next;
    left.next = right.next;
    right.next = temp;

    return dummy.next;
  }
}
