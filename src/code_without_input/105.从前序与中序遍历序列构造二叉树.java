/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
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
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for(int i = 0; i < len; i++){
            indexMap.put(inorder[i], i);
        }
        return myBuild(preorder, inorder, 0, len - 1, 0, len - 1);
    }
    public TreeNode myBuild(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if(pl > pr){
            return null;
        }
        int root_val = preorder[pl];
        int index = indexMap.get(root_val);
        //根据两个遍历中左子树的长度相等
        //index - il = x - pl
        //x = pl + index - il
        //然后就可以求出当前根节点的左右子树在数组中所占的位置，进行递归遍历
        int x = pl + index - il;
        TreeNode root = new TreeNode(root_val);
        root.left = myBuild(preorder, inorder, pl + 1, x, il, index - 1);
        root.right = myBuild(preorder, inorder, x + 1, pr, index + 1, ir);
        return root;
    }
}
// @lc code=end

