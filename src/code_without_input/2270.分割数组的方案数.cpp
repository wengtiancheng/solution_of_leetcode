/*
 * @lc app=leetcode.cn id=2270 lang=cpp
 *
 * [2270] 分割数组的方案数
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        long long left = 0;
        int len = nums.size();
        long long right = 0;
        int count = 0;
        for(int i = 0; i <= len - 1; i++){
            right += nums[i];
        }
        int ptr = 0;
        while(ptr < len - 1){
            left += nums[ptr];
            right -= nums[ptr];
            ptr++;
            if(left >= right){
                count++;
            }
        }
        return count;
    }
};
// @lc code=end

