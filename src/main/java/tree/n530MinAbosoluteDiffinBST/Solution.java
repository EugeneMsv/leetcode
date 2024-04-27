package tree.n530MinAbosoluteDiffinBST;

import tree.n235LowestCommonAncestorOfBT.Solution.TreeNode;

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

  private static int minResult = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    minResult = Integer.MAX_VALUE;
    traverse2(root);
    return minResult;
  }

  private int[] traverse2(TreeNode node) {

    int min = node.val;
    int max = node.val;
    if (node.left != null) {
      int[] left = traverse2(node.left);
      minResult = Math.min(node.val - left[1], minResult);
      min = left[0];
    }
    if (node.right != null) {
      int[] right = traverse2(node.right);
      minResult = Math.min(right[0] - node.val, minResult);
      max = right[1];
    }
    return new int[]{min, max};
  }
}
