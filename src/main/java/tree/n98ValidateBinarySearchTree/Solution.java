package tree.n98ValidateBinarySearchTree;

import tree.n102BinaryTreeLevelOrderTraversal.Solution.TreeNode;

public class Solution {

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

  public boolean isValidBST(TreeNode root) {
    return calcMaxAndMin(root).valid;
  }

  private Range calcMaxAndMin(TreeNode node) {
    if (node == null) {
      return new Range();
    }

    Range left = calcMaxAndMin(node.left);
    if (!left.valid) {
      return left;
    }

    Range right = calcMaxAndMin(node.right);
    if (!right.valid) {
      return right;
    }

    if (node.val <= left.max
        || node.val >= right.min) {
      return new Range(false);
    }

    return
        new Range(Math.max(right.max, node.val), Math.min(left.min, node.val));
  }

  public static class Range {

    private boolean valid = true;
    private long max = Long.MIN_VALUE;
    private long min = Long.MAX_VALUE;

    public Range(long max, long min) {
      this.max = max;
      this.min = min;
    }

    public Range() {
    }

    public Range(boolean valid) {
      this.valid = valid;
    }

  }

}
