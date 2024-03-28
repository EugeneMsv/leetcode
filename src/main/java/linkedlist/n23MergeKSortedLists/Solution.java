package linkedlist.n23MergeKSortedLists;

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

  public ListNode mergeKLists(ListNode[] lists) {

    if (lists.length == 0) {
      return null;
    }

    ListNode result = lists[0];

    for (int i = 1; i < lists.length; i++) {
      result = mergeTwo(result, lists[i]);
    }

    return result;
  }

  private ListNode mergeTwo(ListNode left, ListNode right) {

    ListNode dummy = new ListNode();
    ListNode node = dummy;

    while (left != null && right != null) {

      if (left.val <= right.val) {
        node.next = left;
        left = left.next;
      } else {
        node.next = right;
        right = right.next;
      }
      node = node.next;
    }

    if (left != null) {
      node.next = left;
    }
    if (right != null) {
      node.next = right;
    }

    return dummy.next;
  }
}
