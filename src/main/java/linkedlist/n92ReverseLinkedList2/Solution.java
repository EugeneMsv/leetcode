package linkedlist.n92ReverseLinkedList2;

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

  public ListNode reverseBetween(ListNode head, int left, int right) {

    ListNode prevLeft = null;
    ListNode nextRight = null;

    ListNode node = head;
    int position = 1;
    ListNode subTail = null;
    ListNode firstSubTail = null;
    while (node != null) {
      if (position < left) {
        if (position == left - 1) {
          prevLeft = node;
        }
        node = node.next;
        position++;
        continue;
      }

      if (position == left && position == right) {
        ListNode next = node.next;
        subTail = node;
        firstSubTail = node;
        node = node.next;
        nextRight = next;
        position++;
        break;
      }

      if (position == left) {
        subTail = node;
        firstSubTail = node;
        node = node.next;
        position++;
        continue;
      }
      if (left < position && position < right) {
        ListNode next = node.next;
        node.next = subTail;
        subTail = node;
        node = next;
        position++;
        continue;
      }
      if (position == right) {
        ListNode next = node.next;
        node.next = subTail;
        subTail = node;
        nextRight = next;
        position++;
        break;
      }
      if (position > right) {
        break;
      }

    }
    if (prevLeft != null) {
      prevLeft.next = subTail;
    } else {
      head = subTail;
    }

    if (nextRight != null && firstSubTail != null) {
      firstSubTail.next = nextRight;
    } else if (nextRight == null) {
      firstSubTail.next = null;
    }
    return head;
  }
}