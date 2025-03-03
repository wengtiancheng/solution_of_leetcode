/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第 K 小的元素
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
    //注意是二叉搜索树，所以还是有一些性质可以利用的，而不是单纯地遍历然后排序
    //是不是可以按照一定的顺序遍历，然后不用排序了？
    //二叉树的中序遍历？
    List<Integer> tmp = new ArrayList<>(10001);
    public int kthSmallest(TreeNode root, int k) {
        mid(root);
        return tmp.get(k - 1);
    }
    public void mid(TreeNode root){
        if(root == null){
            return;
        }
        mid(root.left);
        tmp.add(root.val);
        mid(root.right);
    }
}
// @lc code=end

