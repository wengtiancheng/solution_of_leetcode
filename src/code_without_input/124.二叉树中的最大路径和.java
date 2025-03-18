/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    //这里需要注意路径的定义，就是不能有重复的节点
    //如果一个节点的左子节点和右子节点都在路径中
    //那么它就必须为整条路径的根节点，不能再往上寻找了
    //如果还想继续向上寻找，当前节点就只能作为子节点，因此就要从当前节点的左右子节点中选一个更小的舍弃掉
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left_max = Math.max(dfs(node.left), 0);
        int right_max = Math.max(dfs(node.right), 0);
        int tmp = node.val + left_max + right_max;
        max = Math.max(tmp, max);
        return node.val + Math.max(left_max, right_max);
    }
}
// @lc code=end

