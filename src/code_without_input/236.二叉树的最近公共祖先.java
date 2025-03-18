/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    String path_p;
    String path_q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //两个目标一个在左子树，一个在右子树，在此发生了分叉
        if(left != null && right != null){
            return root;
        }
        //暂时没有分叉，返回两个目标都在的那个子树
        return left == null ? right : left;
    }

    
}
// @lc code=end

