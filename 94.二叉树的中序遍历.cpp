/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
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
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;
class Solution {
public:
    
    
    
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> tmp;
        vector<int> res;
        while(root != nullptr || !tmp.empty()){
            while(root != nullptr){
                tmp.push(root);
                root = root->left;
            }
            res.push_back(tmp.top()->val);
            tmp.pop();
            root = root->right;
            
        }
        return res;
    }

    
};
// @lc code=end

