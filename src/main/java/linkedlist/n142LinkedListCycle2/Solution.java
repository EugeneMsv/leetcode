package linkedlist.n142LinkedListCycle2;

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

  public ListNode detectCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;
    ListNode finalSlow = head;
    boolean startFinal = false;

    while (fast != null) {

      if (fast.next == null) {
        return null;
      }

      if (startFinal) {
        finalSlow = finalSlow.next;
      }
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        startFinal = true;
      }
      if (finalSlow == slow) {
        return finalSlow;
      }
    }

    return null;

  }
}
