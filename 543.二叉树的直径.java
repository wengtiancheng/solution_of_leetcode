/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        /**
         * 对于距离最长的两个结点
         * 必定存在一个根节点
         * 使得这两个节点分别存在与这个节点的左子树和右子树上
         * 两个节点之间的距离就是左子树的深度与右子树的深度的和
         * 所以我们只需要遍历二叉树中的所有节点
         * 计算它们左子树和右子树深度的和
         * 然后维护一个最大值
         * 
         * 我当时无法解决的问题是最大值的维护的问题
         * 我想的是先计算出每个节点的深度，然后再从上往下遍历，遍历的过程才开始维护这个最大值
         * 其实计算深度的过程已经使用到了每个节点左子树和右子树的深度，这个最大值已经可以开始维护了
         */
        max = 1;
        depth(root);
        return max - 1;
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

