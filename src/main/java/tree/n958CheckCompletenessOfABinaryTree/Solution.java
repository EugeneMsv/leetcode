package tree.n958CheckCompletenessOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

 public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
   val = x;
  }
 }
 public boolean isCompleteTree(TreeNode root) {
  if (root == null){
   return true;
  }

  Queue<TreeNode> q = new LinkedList<>();
  q.offer(root);

  while (q.peek() != null) {
   TreeNode node = q.poll();
   q.offer(node.left);
   q.offer(node.right);
  }

  while (!q.isEmpty() && q.peek() == null){
   q.poll();
  }

  return q.isEmpty();
 }
}
