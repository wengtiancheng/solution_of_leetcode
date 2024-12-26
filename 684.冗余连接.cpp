/*
 * @lc app=leetcode.cn id=684 lang=cpp
 *
 * [684] 冗余连接
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int len = edges.size();
        vector<int> parent(len + 1, 0);
        for(int i = 1; i <= len; i++){
            parent[i] = i;
        }
        vector<int> res = {};
        for(int i = 0; i < len; i++){
            int index1 = edges[i][0];
            int index2 = edges[i][1];
            if(findParent(parent, index1) != findParent(parent, index2)){
                Union(parent, index1, index2);
            }else{
                res = edges[i];
            }
        }
        return res;
        
    }

    int findParent(vector<int> &parent, int index){
        if(parent[index] != index){
            parent[index] = findParent(parent, parent[index]);
        }

        return parent[index];
    }

    void Union(vector<int> &parent, int index1, int index2){
        parent[findParent(parent,index1)] = findParent(parent, index2);
    }
};
// @lc code=end

