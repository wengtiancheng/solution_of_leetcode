/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 轮转数组
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + (k % len));
        reverse(nums.begin() + (k % len), nums.end());
    }
};
// @lc code=end

