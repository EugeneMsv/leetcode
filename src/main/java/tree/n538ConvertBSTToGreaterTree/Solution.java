package tree.n538ConvertBSTToGreaterTree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
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
 public TreeNode convertBST(TreeNode root) {
  traverse(root, 0);
  return root;
 }


 private int traverse(TreeNode node, int parentSum){
  if(node == null){
   return 0;
  }
  int originalVal =  node.val;
  int rightSum = 0;
  if(node.right !=null){
   rightSum = traverse(node.right, parentSum);
  }

  node.val = node.val+ parentSum+rightSum;

  int leftSum = 0;
  if(node.left !=null){
   leftSum =traverse(node.left, node.val);
  }


  return originalVal + rightSum + leftSum;
 }
}
