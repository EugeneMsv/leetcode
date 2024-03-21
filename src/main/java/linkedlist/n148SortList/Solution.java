package linkedlist.n148SortList;

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

  public ListNode sortList(ListNode head) {

    int size = 0;

    ListNode node = head;
    while (node != null) {
      size++;
      node = node.next;
    }

    return mergeSort(head, size);

  }

  private ListNode mergeSort(ListNode head, int size) {
    if (head == null) {
      return null;
    }
    if (size == 0) {
      return null;
    }
    if (size == 1) {
      head.next = null;
      return head;
    }

    int mid = size / 2;

    ListNode node = head;
    int count = 0;
    while (count < mid) {
      count++;
      node = node.next;
    }

    ListNode sortedHead = mergeSort(head, mid);
    ListNode sortedMid = mergeSort(node, size - mid);
    ListNode dummy = new ListNode(Integer.MAX_VALUE);
    ListNode result = dummy;

    while (sortedMid != null && sortedHead != null) {
      if (sortedHead.val <= sortedMid.val) {
        result.next = sortedHead;
        sortedHead = sortedHead.next;
      } else {
        result.next = sortedMid;
        sortedMid = sortedMid.next;
      }
      result = result.next;
    }
    if (sortedMid != null) {
      result.next = sortedMid;
    }

    if (sortedHead != null) {
      result.next = sortedHead;
    }

    return dummy.next;
  }
}
