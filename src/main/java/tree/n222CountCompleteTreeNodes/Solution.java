package tree.n222CountCompleteTreeNodes;

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

  private static int height;

  private static int leavesCount = 0;

  private static boolean done = false;

  public int countNodes(TreeNode root) {
    done = false;
    height = calcHeight(root);
    leavesCount = 0;
    if (height < 0) {
      return 0;
    }
    if (height == 0) {
      return 1;
    }

    traverse(root, 0);
    return leavesCount + (int) Math.pow(2, height) - 1;

  }

  private void traverse(TreeNode node, int h) {
    if (done) {
      return;
    }
    if (node == null) {
      return;
    }

    if (h == height - 1) {

      TreeNode left = node.left;
      TreeNode right = node.right;
      if (right == null) {
        leavesCount += left == null ? 0 : 1;
        done = true;
      } else {
        leavesCount += 2;
      }
      return;

    } else {
      traverse(node.left, h + 1);
      traverse(node.right, h + 1);
    }
  }

  private int calcHeight(TreeNode node) {
    int height = -1;
    while (node != null) {
      height++;
      node = node.left;
    }
    return height;
  }
}
