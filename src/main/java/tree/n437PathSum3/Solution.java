package tree.n437PathSum3;

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
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private static int paths;

  public int pathSum(TreeNode root, int targetSum) {
    paths = 0;
    dfs(root, new LinkedList<>(), targetSum);
    return paths;
  }

  private void dfs(TreeNode node, List<Integer> list, int targetSum) {
    if (node == null) {
      return;
    }

    long sum = node.val;
    if (sum == targetSum) {
      paths++;
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      sum += list.get(i);
      if (sum == targetSum) {
        paths++;
      }
    }

    list.add(node.val);
    dfs(node.left, list, targetSum);
    dfs(node.right, list, targetSum);
    list.remove(list.size() - 1);
  }
}
