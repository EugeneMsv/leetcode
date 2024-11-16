package tree.n513FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class Solution {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    TreeNode result = null;

    while (!q.isEmpty()) {
      result = q.peek();
      int size = q.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
    }

    return result.val;
  }
}
