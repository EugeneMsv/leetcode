package linkedlist.n2AddTwoNumbers;

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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int oveflowed = 0;
    ListNode first = l1;
    ListNode second = l2;
    ListNode dummyHead = new ListNode();
    ListNode sumNode = dummyHead;
    while (first != null && second != null) {
      int sum = first.val + second.val + oveflowed;
      oveflowed = sum / 10;
      sumNode.next = new ListNode(sum % 10);
      sumNode = sumNode.next;
      first = first.next;
      second = second.next;
    }
    while (first != null) {
      int sum = first.val + oveflowed;
      oveflowed = sum / 10;
      sumNode.next = new ListNode(sum % 10);
      sumNode = sumNode.next;
      first = first.next;
    }
    while (second != null) {
      int sum = second.val + oveflowed;
      oveflowed = sum / 10;
      sumNode.next = new ListNode(sum % 10);
      sumNode = sumNode.next;
      second = second.next;
    }
    if (oveflowed > 0) {
      sumNode.next = new ListNode(oveflowed);
    }

    return dummyHead.next;

  }

}
