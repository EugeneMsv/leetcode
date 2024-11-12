package tree.n116PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
 class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
   val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
   val = _val;
   left = _left;
   right = _right;
   next = _next;
  }
 };
 public Node connect(Node root) {
  if(root == null){
   return null;
  }

  Queue<Node> q = new LinkedList<>();
  q.offer(root);

  while(!q.isEmpty()){
   int size = q.size();
   Node prev = null;
   for(int i = 0; i < size; i++){
    Node node = q.poll();
    if(prev == null){
     prev =  node;
    } else{
     prev.next = node;
     prev = node;
    }
    if(node.left != null){
     q.offer(node.left);
    }
    if(node.right != null){
     q.offer(node.right);
    }
   }
  }

  return root;
 }
}