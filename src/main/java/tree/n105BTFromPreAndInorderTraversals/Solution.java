package tree.n105BTFromPreAndInorderTraversals;

import java.util.Arrays;
import tree.n102BinaryTreeLevelOrderTraversal.Solution.TreeNode;

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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return findRoot(preorder, inorder);
  }

  private TreeNode findRoot(int[] preorder, int[] inorder) {
    // System.out.print("preorder = "+Arrays.toString(preorder)+ " inorder = "+Arrays.toString(inorder));
    TreeNode root = new TreeNode(preorder[0]);
    int inorderIdx = -1;
    for (int i = 0; i < inorder.length; i++) {
      if (root.val == inorder[i]) {
        inorderIdx = i;
        break;
      }
    }
    // System.out.println(" root = "+root.val+" inorder idx = "+inorderIdx);

    if (inorderIdx > 0) {
      int[] leftPreorder = Arrays.copyOfRange(preorder, 1, inorderIdx + 1);
      int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderIdx);
      root.left = findRoot(leftPreorder, leftInorder);
    }

    if (preorder.length - 1 > inorderIdx) {
      int[] rightPreorder = Arrays.copyOfRange(preorder, inorderIdx + 1, preorder.length);
      int[] rightInorder = Arrays.copyOfRange(inorder, inorderIdx + 1, preorder.length);
      root.right = findRoot(rightPreorder, rightInorder);
    }

    return root;
  }
}
