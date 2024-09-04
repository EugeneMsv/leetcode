package tree.n124BinaryTreeMaximumPathSum;

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
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 private static int MIN_VALUE= Integer.MIN_VALUE+300000;
 private static int max ;

 public int maxPathSum(TreeNode root) {
  max = MIN_VALUE;

  maxSum(root);

  return max;

 }

 public int maxSum(TreeNode node) {
  if(node == null){
   return 0;
  }
  max = Math.max(max, node.val);
  if(node.left == null && node.right == null){
   return node.val;
  }

  int leftSum =  Math.max(0, maxSum(node.left));
  int rightSum = Math.max(0, maxSum(node.right));;

  int currentMax = Math.max(leftSum, rightSum) +node.val;

  max = Math.max(max,  leftSum +rightSum + node.val);

  return currentMax;
 }


}