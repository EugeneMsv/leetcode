package tree.n572SubtreeOfAnotherTree;

public class Solution {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null || root == null) {
      return subRoot == null && root == null;
    }
    if (isSame(root, subRoot)) {
      return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  boolean isSame(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == null && q == null;
    }

    if (p.val != q.val) {
      return false;
    }
    return isSame(p.left, q.left)
        && isSame(p.right, q.right);
  }

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

}
