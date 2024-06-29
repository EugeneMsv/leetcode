package tree.n1372LongestZigZagPathInABinaryTree;

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

  private static int maxZigZag = 0;

  public int longestZigZag(TreeNode root) {
    maxZigZag = 0;
    if (root == null) {
      return 0;
    }
    dfs(root.left, true, 1);
    dfs(root.right, false, 1);
    return maxZigZag;
  }

  private void dfs(TreeNode node, boolean isLeft, int zigZagLength) {
    if (node == null) {
      return;
    }
    maxZigZag = Math.max(maxZigZag, zigZagLength);

    // If node comes from the same side (left or right)
    // then we reset length to 1.
    // 1 is because we count current plus next node length
    dfs(node.left, true, isLeft ? 1 : zigZagLength + 1);
    dfs(node.right, false, isLeft ? zigZagLength + 1 : 1);
  }
}
