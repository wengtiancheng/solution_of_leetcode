/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;



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
//为了尽快做出来，看到是要前序遍历，就可以不要一边遍历一边处理，可以先遍历后处理
class Solution {
    
    public void flatten(TreeNode root) {
       List<TreeNode> tmp = new LinkedList<>();
       preorderTraversal(root, tmp);
       for(int i = 0; i < tmp.size() - 1; i++){
        TreeNode cur = tmp.get(i);
        TreeNode next = tmp.get(i + 1);
        cur.left = null;
        cur.right = next;
       }

    }
    public void preorderTraversal(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
// @lc code=end

