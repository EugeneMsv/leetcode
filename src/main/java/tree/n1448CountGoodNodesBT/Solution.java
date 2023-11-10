package tree.n1448CountGoodNodesBT;

import java.util.LinkedList;
import java.util.List;

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

  public int goodNodes(TreeNode root) {
    List<TreeNode> goodNodes = new LinkedList<>();
    dfs(goodNodes, root, root.val);
    return goodNodes.size();
  }

  private void dfs(List<TreeNode> goodNodes, TreeNode node, int currentMax) {
    if (node == null) {
      return;
    }

    if (node.val >= currentMax) {
      goodNodes.add(node);
    }
    int newMax = Math.max(currentMax, node.val);

    dfs(goodNodes, node.left, newMax);
    dfs(goodNodes, node.right, newMax);

  }
}