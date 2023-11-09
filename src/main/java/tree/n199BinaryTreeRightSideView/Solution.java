package tree.n199BinaryTreeRightSideView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> rightSideView(TreeNode root) {

    Queue<TreeNode> level = new LinkedList<>();
    if (root != null) {
      level.add(root);
    }
    List<Integer> rightView = new LinkedList<>();
    while (!level.isEmpty()) {
      int levelSize = level.size();
      for (int i = 1; i < levelSize; i++) {
        TreeNode node = level.poll();
        if (node.left != null) {
          level.add(node.left);
        }
        if (node.right != null) {
          level.add(node.right);
        }
      }
      // Last node on level
      TreeNode lastLevelNode = level.poll();
      rightView.add(lastLevelNode.val);
      if (lastLevelNode.left != null) {
        level.add(lastLevelNode.left);
      }
      if (lastLevelNode.right != null) {
        level.add(lastLevelNode.right);
      }

    }
    return rightView;
  }
}
