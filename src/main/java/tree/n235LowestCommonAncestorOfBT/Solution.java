package tree.n235LowestCommonAncestorOfBT;

public class Solution {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    return dfsAncestor(root, p, q);
  }

  TreeNode dfsAncestor(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) {
      return null;
    }
    int value = node.val;
    if (value > p.val && value > q.val) {
      return dfsAncestor(node.left, p, q);
    } else if (value < p.val && value < q.val) {
      return dfsAncestor(node.right, p, q);
    } else if (value == p.val || value == q.val) {
      return node;
    } else {
      return node;
    }
  }
}
