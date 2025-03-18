/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return helper(nums, 0, len - 1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode tmp = new TreeNode(nums[mid]);
        tmp.left = helper(nums, left, mid - 1);
        tmp.right = helper(nums, mid + 1, right);
        return tmp;
    }
}
// @lc code=end

