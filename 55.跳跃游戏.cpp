/*
 * @lc app=leetcode.cn id=55 lang=cpp
 *
 * [55] 跳跃游戏
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    bool canJump(vector<int>& nums) {
       int n = nums.size();
       int right_most = 0;
       for(int i = 0; i < n; i++){
            if(right_most >= i){
                right_most = max(right_most, i + nums[i]);
            }
       }
       if(right_most >= n - 1){
        return true;
       }
       return false;
        
    }
};
// @lc code=end

