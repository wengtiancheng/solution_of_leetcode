/*
 * @lc app=leetcode.cn id=3065 lang=cpp
 *
 * [3065] 超过阈值的最少操作数 I
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int count = 0;
        int len = nums.size();
        for(int i = 0; i < len; i++){
            if(nums[i] <  k){
                count++;
            }
        }
        return count;
    }
};
// @lc code=end

