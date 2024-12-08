package tree.n515FindLargestValueInEachTreeRow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
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

  public List<Integer> largestValues(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<Integer> result = new LinkedList<>();

    if (root != null) {
      q.offer(root);
    }

    while (!q.isEmpty()) {

      int size = q.size();
      int max = Integer.MIN_VALUE;

      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        max = Math.max(node.val, max);

        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      result.add(max);
    }

    return result;
  }
}
