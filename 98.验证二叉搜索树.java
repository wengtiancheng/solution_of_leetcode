/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    //之前的方法有点问题，a < a.right, a.right.left < a.right，a和a.right.left的值不好比较
    //可能需要维护一个左子树的最大值和右子树的最小值？
    long MAX = Long.MAX_VALUE;
    long MIN = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValidBST(root.left) && isValidBST(root.right) && (left_max(root) < root.val) && (right_min(root) > root.val);
    }

    public long left_max(TreeNode root) {
    if (root == null || root.left == null) {
        return MIN;
    }
    return Math.max(root.left.val, Math.max(left_max(root.left), right_max(root.left)));
}

public long left_min(TreeNode root) {
    if (root == null || root.left == null) {
        return MAX;
    }
    return Math.min(root.left.val, Math.min(left_min(root.left), right_min(root.left)));
}

public long right_max(TreeNode root) {
    if (root == null || root.right == null) {
        return MIN;
    }
    return Math.max(root.right.val, Math.max(left_max(root.right), right_max(root.right)));
}

public long right_min(TreeNode root) {
    if (root == null || root.right == null) {
        return MAX;
    }
    return Math.min(root.right.val, Math.min(left_min(root.right), right_min(root.right)));
}

}
// @lc code=end

