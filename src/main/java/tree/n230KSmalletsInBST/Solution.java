package tree.n230KSmalletsInBST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int kthSmallest(TreeNode root, int k) {
    return kthSmallestIterative(root, k);
  }

  public int kthSmallestRecursive(TreeNode root, int k) {
    List<TreeNode> traversed = new ArrayList<>(k);
    traverse(traversed, root, k);
    return traversed.get(k - 1).val;
  }

  private void traverse(List<TreeNode> traversed, TreeNode node, int k) {
    if (node == null) {
      return;
    }

    traverse(traversed, node.left, k);
    traversed.add(node);
    if (traversed.size() >= k) {
      return;
    }
    traverse(traversed, node.right, k);
  }

  private int kthSmallestIterative(TreeNode root, int k) {
    int position = 0;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      TreeNode processing = stack.pop();
      position++;
      if (position == k) {
        return processing.val;
      }
      node = processing.right;

    }
    return Integer.MIN_VALUE;
  }
}
