package tree.n236LowestCommonAncestorOfBT;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
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

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pPath = new LinkedList<>();
    List<TreeNode> qPath = new LinkedList<>();
    searchNode(root, p, pPath);
    searchNode(root, q, qPath);
    // for(TreeNode node: pPath){
    //     System.out.print(node.val+"->");
    // }
    //     System.out.println();
    //   for(TreeNode node: qPath){
    //     System.out.print(node.val+"->");
    // }

    int i = 0;
    while (i < pPath.size() && i < qPath.size()) {
      if (pPath.get(i).val != qPath.get(i).val) {
        return pPath.get(i - 1);
      }
      i++;
    }

    return pPath.size() < qPath.size() ? pPath.get(i - 1) : qPath.get(i - 1);
  }

  private boolean searchNode(TreeNode node, TreeNode target, List<TreeNode> path) {
    if (node == null) {
      return false;
    }

    path.add(node);
    if (node.val == target.val) {

      return true;
    }

    boolean result = searchNode(node.left, target, path)
        || searchNode(node.right, target, path);

    if (result) {
      return true;
    } else {
      path.remove(path.size() - 1);
      return false;
    }

  }
}
