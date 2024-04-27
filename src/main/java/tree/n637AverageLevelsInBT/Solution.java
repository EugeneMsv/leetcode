package tree.n637AverageLevelsInBT;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    List<Double> l = new LinkedList<>();
    while (!q.isEmpty()) {

      double average = 0.0;
      int size = q.size();
      //old average * (n-1)/n + new value /n
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        if (i == 0) {
          average += (double) node.val;
        } else {
          average = average * i / (i + 1) + (double) node.val / (i + 1);
        }
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      l.add(average);
    }
    return l;
  }
}
