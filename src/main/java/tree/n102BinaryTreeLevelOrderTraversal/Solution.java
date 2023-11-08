package tree.n102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

  public List<List<Integer>> levelOrder(TreeNode root) {

    Queue<TreeNode> level = new LinkedList<>();
    if (root != null) {
      level.add(root);
    }
    List<List<Integer>> levelsResult = new LinkedList<>();
    while (!level.isEmpty()) {

      int levelLength = level.size();
      List<Integer> levelResult = new ArrayList<>(levelLength);
      for (int i = 1; i <= levelLength; i++) {
        TreeNode node = level.poll();
        levelResult.add(node.val);
        if (node.left != null) {
          level.add(node.left);
        }
        if (node.right != null) {
          level.add(node.right);
        }
      }
      levelsResult.add(levelResult);
    }
    return levelsResult;
  }
}
