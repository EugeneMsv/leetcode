package tree.n783MinimumDistanceBetweenBSTNodes;

import java.util.ArrayList;
import java.util.List;

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

  public int minDiffInBST(TreeNode root) {
    List<Integer> nodes = new ArrayList<>();
    traverseInOrder(nodes, root);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < nodes.size(); i++) {
      int diff = nodes.get(i) - nodes.get(i - 1);
      minDiff = Math.min(minDiff, diff);
    }

    return minDiff;
  }

  private void traverseInOrder(List<Integer> nodes, TreeNode node) {
    if (node == null) {
      return;
    }

    traverseInOrder(nodes, node.left);
    nodes.add(node.val);
    traverseInOrder(nodes, node.right);

  }
}