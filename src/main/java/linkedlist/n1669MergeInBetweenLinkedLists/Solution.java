package linkedlist.n1669MergeInBetweenLinkedLists;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
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

  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode node = list1;
    ListNode start = null;
    ListNode end = null;
    int i = 0;
    while (i <= b + 1 && node != null) {
      if (i == a - 1) {
        start = node;
      }
      if (i == b + 1) {
        end = node;
      }
      node = node.next;
      i++;
    }

    ListNode lastIn2 = null;
    node = list2;
    while (node.next != null) {
      node = node.next;
    }
    start.next = list2;
    node.next = end;

    return list1;
  }
}
