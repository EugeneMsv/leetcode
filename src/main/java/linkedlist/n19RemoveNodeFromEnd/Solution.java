package linkedlist.n19RemoveNodeFromEnd;

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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode endNavigator = head;
    ListNode nthDelay = head;
    ListNode prevNthDelay = head;

    int position = 1;

    while (endNavigator.next != null) {

      if (position >= n) {
        prevNthDelay = nthDelay;
        nthDelay = nthDelay.next;
      }

      endNavigator = endNavigator.next;
      position++;
    }

    if (nthDelay == head) {
      return head.next;
    }
    prevNthDelay.next = nthDelay.next;

    return head;
  }
}