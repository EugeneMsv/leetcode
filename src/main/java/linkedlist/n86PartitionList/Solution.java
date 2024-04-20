package linkedlist.n86PartitionList;

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

  public ListNode partition(ListNode head, int x) {
    ListNode dummyLeft = new ListNode();
    ListNode less = dummyLeft;

    ListNode dummyRight = new ListNode();
    ListNode greater = dummyRight;

    ListNode node = head;

    while (node != null) {
      ListNode next = node.next;
      node.next = null;
      if (node.val < x) {
        less.next = node;
        less = less.next;
      } else {
        greater.next = node;
        greater = greater.next;
      }
      node = next;
    }

    less.next = dummyRight.next;

    return dummyLeft.next;
  }
}
