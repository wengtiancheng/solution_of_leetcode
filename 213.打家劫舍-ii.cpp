/*
 * @lc app=leetcode.cn id=213 lang=cpp
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int rob(vector<int>& nums) {
        int len = nums.size();
        vector<int> dp(len + 1);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++){
            dp[i] = max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
    }
};
// @lc code=end

