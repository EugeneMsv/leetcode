package tree.n2415ReverseOddLevelsOfBinaryTree;

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

  public TreeNode reverseOddLevels(TreeNode root) {
    LinkedList<TreeNode> list = new LinkedList<>();
    Queue<TreeNode> q = list;
    int level = 0;
    q.offer(root);

    while (!q.isEmpty()) {

      if (level % 2 != 0) {
        //For odd levels we reverse values only
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
          TreeNode leftNode = list.get(left);
          TreeNode rightNode = list.get(right);
          int tempVal = leftNode.val;
          leftNode.val = rightNode.val;
          rightNode.val = tempVal;
          left++;
          right--;
        }

      }

      int levelSize = q.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = q.poll();
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }

      level++;

    }

    return root;

  }
}
