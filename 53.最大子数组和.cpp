/*
 * @lc app=leetcode.cn id=53 lang=cpp
 *
 * [53] 最大子数组和
 */

// @lc code=start
#include <vector>
#include <climits>
using namespace std;
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSum = INT_MIN; // 用于存储最大子数组和
        int currentSum = 0;   // 当前子数组的和

        for (int num : nums) {
            currentSum = max(num, currentSum + num); // 当前子数组的和，决定是否从当前元素重新开始
            maxSum = max(maxSum, currentSum);       // 更新最大子数组和
        }
        return maxSum; // 返回结果
    }
};

// @lc code=end

