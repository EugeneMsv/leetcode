package linkedlist.n82RemoveDuplicatesFromSortedList;

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

  public static class ListNode {

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

  public ListNode deleteDuplicates(ListNode head) {

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode node = head;
    ListNode prevEnd = dummy;
    ListNode prev = dummy;
    int repetitions = 1;

    while (node != null) {
      if (node.val == prev.val) {
        repetitions++;
        prev = node;
        node = node.next;
        continue;
      } else {
        if (repetitions > 1) {
          repetitions = 1;
          prevEnd.next = node;

        } else {
          prevEnd = prev;
        }

        prev = node;
        node = node.next;
      }

    }

    if (repetitions > 1) {
      prevEnd.next = null;

    }

    return dummy.next;
  }
}