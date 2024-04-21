package tree.n129SumRootToLeafNumbers;

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

  private static int result;

  public int sumNumbers(TreeNode root) {
    result = 0;
    dfs(root, new StringBuilder());
    return result;
  }

  private void dfs(TreeNode node, StringBuilder s) {
    if (node == null) {
      return;
    }

    s.append(node.val);

    if (node.left == null && node.right == null) {
      result += Integer.valueOf(s.toString());
    } else {
      dfs(node.left, s);
      dfs(node.right, s);
    }
    s.deleteCharAt(s.length() - 1);
  }
}
