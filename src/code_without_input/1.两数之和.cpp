/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
#include <vector>
#include <unordered_map>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int len =  nums.size();
        unordered_map<int, int> res = {};
        vector<int> fuck;
        int tmp = 0;
        for(int i = 0; i < len; i++){
            tmp =  target - nums[i];
            if(res.find(tmp) != res.end()){
                return {res[tmp], i};
            }
            res[nums[i]] = i;


        }
        return {};
    }
};
// @lc code=end

