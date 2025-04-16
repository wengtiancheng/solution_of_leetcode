/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return equal(root.left, root.right);
        
    }
    public boolean equal(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null){
            return false;
        }else if(right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return equal(left.left, right.right) && equal(left.right, right.left);
    }
}
// @lc code=end

