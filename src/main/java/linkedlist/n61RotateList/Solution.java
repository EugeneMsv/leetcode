package linkedlist.n61RotateList;

import linkedlist.n23MergeKSortedLists.Solution.ListNode;

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

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    int n = 0;
    ListNode node = head;
    while (node != null) {
      n++;
      node = node.next;
    }
    k = k % n;
    if (k == 0) {
      return head;
    }

    node = head;
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode prevKNode = dummy;
    int count = 0;
    ListNode prev = null;
    while (node != null) {
      prev = node;
      node = node.next;
      count++;

      if (count > k) {
        prevKNode = prevKNode.next;
      }
    }

    ListNode newHead = prevKNode.next;
    prevKNode.next = null;
    if (prev != null) {
      prev.next = head;
    }

    return newHead;
  }
}