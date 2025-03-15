/*
 * @lc app=leetcode.cn id=910 lang=cpp
 *
 * [910] 最小差值 II
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int smallestRangeII(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int len = nums.size();
        if(nums[len - 1] -  nums[0] >= 2 * k){
            for(int i = 0; i < len; i++){
                if(nums[i] <= nums[0] + k){
                    nums[i] += k;
                }else{
                    nums[i] -= k;
                }
                
            }
            
        }else{
            int mid = (nums[len - 1] + nums[0]) / 2;
             for(int i = 0; i < len; i++){
                if(nums[i] <= mid){
                    nums[i] += k;
                }else{
                    nums[i] -= k;
                }
                
            }
            
        }
        sort(nums.begin(), nums.end());
        return nums[len - 1] - nums[0];

        
    }
};
// @lc code=end

