package linkedlist.n2130MaximumTwinSumOfALinkedList;

//  Definition for singly-linked list.
public class Solution {

  public int pairSum(ListNode head) {

    int size = 0;
    ListNode node = head;
    while (node != null) {
      size++;
      node = node.next;
    }

    int middle = size / 2;
    node = head;
    int index = 1;
    ListNode prev = null;
    while (node != null) {
      if (index <= middle) {
        index++;
        node = node.next;
      } else {
        ListNode temp = node.next;
        node.next = prev;
        prev = node;
        node = temp;
        index++;
      }
    }

    int max = Integer.MIN_VALUE;
    ListNode twin = prev;
    ListNode origin = head;
    for (int i = 1; i <= middle; i++) {
      max = Math.max(origin.val + twin.val, max);
      origin = origin.next;
      twin = twin.next;
    }
    return max;
  }
}

class ListNode {

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
