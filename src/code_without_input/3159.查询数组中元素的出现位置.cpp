/*
 * @lc app=leetcode.cn id=3159 lang=cpp
 *
 * [3159] 查询数组中元素的出现位置
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> occurrencesOfElement(vector<int>& nums, vector<int>& queries, int x) {
        int len = nums.size();
        vector<int> pos;
        for(int i = 0; i < len; i++){
            if(nums[i] == x){
                pos.push_back(i);
            }
        }
        for(int& q : queries){
            q = q > pos.size() ? -1 : pos[q - 1];
        }
        return queries;
        
    }
};
// @lc code=end

