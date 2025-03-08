/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    Map<Integer, Integer> res = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        view(root, 0);
        int count = 0;
        List<Integer> tmp = new LinkedList<>();
        while(res.containsKey(count)){
            tmp.add(res.get(count));
            count++;
        }
        return tmp;
    }
    public void view(TreeNode node, int depth){
        if(node == null){
            return;
        }
        view(node.left, depth + 1);
        res.put(depth, node.val);
        view(node.right, depth + 1);
    }
}
// @lc code=end

