package tree.n700SearchInABinaryTree;

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

  public TreeNode searchBST(TreeNode root, int val) {
    return binarySearch(root, val);
  }

  private TreeNode binarySearch(TreeNode node, int target) {
    if (node == null) {
      return null;
    }

    if (node.val == target) {
      return node;
    }

    return node.val > target
        ? binarySearch(node.left, target)
        : binarySearch(node.right, target);

  }
}
