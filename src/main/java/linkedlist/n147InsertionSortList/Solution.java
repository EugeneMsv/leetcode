package linkedlist.n147InsertionSortList;


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

  public ListNode insertionSortList(ListNode head) {
    ListNode curr = head, next = null;
    // dummy is a fake head for sorted list
    ListNode dummy = new ListNode(0);

    while (curr != null) {
      //Save next node for later
      next = curr.next;

      ListNode sortedNode = dummy;
      while (sortedNode.next != null && sortedNode.next.val < curr.val) {
        sortedNode = sortedNode.next;
      }

      // insert curr between sortedNode and sortedNode.next
      curr.next = sortedNode.next;
      sortedNode.next = curr;

      // Move to saved next
      curr = next;
    }

    return dummy.next;
  }

}
