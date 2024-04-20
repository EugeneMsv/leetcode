package tree.n114FlattenBinaryTreeToLinkedList;

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

  public void flatten(TreeNode root) {
    traverse(root);
  }

  private TreeNode traverse(TreeNode node) {
    if (node == null) {
      return null;
    }

    TreeNode left = node.left;
    TreeNode right = node.right;

    if (left == null && right == null) {
      return node;
    }

    TreeNode lastLeft = traverse(left);
    TreeNode lastRight = traverse(right);

    node.left = null;
    if (lastLeft != null) {
      node.right = left;
      lastLeft.right = right;
    } else {
      node.right = right;
    }
    return lastRight == null ? lastLeft : lastRight;

  }
}
