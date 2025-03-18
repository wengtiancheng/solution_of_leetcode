/*
 * @lc app=leetcode.cn id=1367 lang=cpp
 *
 * [1367] 二叉树中的链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
// ... existing code ...
class Solution {
public:
    bool isSubPath(ListNode* head, TreeNode* root) {
        if (!root) return false; // 如果树为空，返回 false
        if (checkPath(head, root)) return true; // 检查当前节点是否匹配链表
        // 递归检查左子树和右子树
        return isSubPath(head, root->left) || isSubPath(head, root->right);
    }

private:
    bool checkPath(ListNode* head, TreeNode* node) {
        if (!head) return true; // 链表已匹配完，返回 true
        if (!node || node->val != head->val) return false; // 节点不匹配或树为空，返回 false
        // 继续检查下一个链表节点与当前树节点的子节点
        return checkPath(head->next, node->left) || checkPath(head->next, node->right);
    }
};
// ... existing code ...
// @lc code=end

