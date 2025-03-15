/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {

        List<Long> currentSums = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        mySum(root, targetSum, currentSums);
        return count;

    }

    public void mySum(TreeNode root, int targetSum, List<Long> currentSums) {
        if (root == null) {
            return;
        }

        // 用额外的 `List` 存储新路径和，防止修改 `currentSums` 时遍历错误
        List<Long> newSums = new LinkedList<>();
        for (long sum : currentSums) {
            long newSum = sum + root.val;
            if (newSum == targetSum) {
                count++;
            }
            newSums.add(newSum);
        }

        // 单独判断当前节点值是否等于 `targetSum`
        if (root.val == targetSum) {
            count++;
        }

        
        newSums.add((long)root.val);

        // 递归调用左子树和右子树，使用新列表确保独立性
        mySum(root.left, targetSum, new LinkedList<>(newSums));
        mySum(root.right, targetSum, new LinkedList<>(newSums));
    }
    
}
// @lc code=end
