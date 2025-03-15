/*
 * @lc app=leetcode.cn id=908 lang=cpp
 *
 * [908] 最小差值 I
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int len = nums.size();
        if(nums[len - 1] - nums[0] <= 2 * k){
            return 0;  
        }
        return nums[len - 1] - nums[0] - 2 * k;
        
    }
};
// @lc code=end

