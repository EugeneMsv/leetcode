package tree.n872LeafSimilarTrees;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class Solution {

  public class TreeNode {

    int val;
    Solution.TreeNode left;
    Solution.TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static int checkIdx = 0;

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    checkIdx = 0;
    List<Integer> leaves1 = new LinkedList<>();
    fillLeaves(root1, leaves1);
    return checkLeaves(root2, leaves1) && checkIdx == leaves1.size();
  }

  private void fillLeaves(TreeNode node, List<Integer> leaves) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      leaves.add(node.val);
      return;
    }
    fillLeaves(node.left, leaves);
    fillLeaves(node.right, leaves);
  }

  private boolean checkLeaves(TreeNode node, List<Integer> leaves) {
    if (node == null) {
      return true;
    }
    if (node.left == null && node.right == null) {
      boolean result = checkIdx < leaves.size() && leaves.get(checkIdx).equals(node.val);
      checkIdx++;
      return result;
    }
    return checkLeaves(node.left, leaves) &&
        checkLeaves(node.right, leaves);
  }
}

