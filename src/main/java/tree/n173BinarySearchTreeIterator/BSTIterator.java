package tree.n173BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class BSTIterator {

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

  private final Stack<TreeNode> s = new Stack<>();

  private TreeNode lastReturned = new TreeNode();

  public BSTIterator(TreeNode root) {
    pushAllLeft(root);
  }

  public int next() {
    TreeNode next = s.pop();
    TreeNode right = next.right;
    if (right != null) {
      pushAllLeft(right);
    }
    return next.val;
  }

  public boolean hasNext() {
    return !s.isEmpty();
  }

  private void pushAllLeft(TreeNode node) {
    TreeNode n = node;
    while (n != null) {
      s.push(n);
      n = n.left;
    }
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
 * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */