package linkedlist.n2816DoubleLinkedListNumber;



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
 public ListNode doubleIt(ListNode head) {
  ListNode dummy =  new ListNode(0);
  dummy.next = head;
  ListNode prev = dummy;
  ListNode node = head;

  while(node != null){
   int toPrev = 2*node.val /10;
   int updated = 2*node.val % 10;
   prev.val+=toPrev;
   node.val =  updated;
   node = node.next;
   prev =  prev.next;
  }

  return dummy.val >0 ? dummy : dummy.next;
 }
}
