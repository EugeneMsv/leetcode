package tree.n1161MaximumLevelSumOfABinaryTree;

import java.util.LinkedList;
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

    TreeNode(int x) {
      val = x;
    }
  }

  public int maxLevelSum(TreeNode root) {

    int max = Integer.MIN_VALUE;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 1;
    int resultLevel = level;
    while (!queue.isEmpty()) {
      int size = queue.size();
      int sum = 0;

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }

      }
      if (sum > max) {
        max = sum;
        resultLevel = level;
      }
      level++;
    }

    return resultLevel;

  }
}