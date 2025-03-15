/*
 * @lc app=leetcode.cn id=3046 lang=cpp
 *
 * [3046] 分割数组
 */

// @lc code=start
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool isPossibleToSplit(vector<int>& nums) {
        unordered_map<int, int> res;
        
        for(const auto& it: nums){
            if(++res[it] > 2){
                return false;
            }
        }
        return true;
        
    }
};
// @lc code=end

