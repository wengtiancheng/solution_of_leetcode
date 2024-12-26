/*
 * @lc app=leetcode.cn id=3171 lang=cpp
 *
 * [3171] 找到按位或最接近 K 的子数组
 */

// @lc code=start
#include <vector>
#include <climits>
#include <math.h>
using namespace std;
class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        int ans = INT_MAX;
        int left = 0;
        int right = 0;
        int bottom = 0;
        int right_or = 0;
        for(right = 0; right < nums.size(); right++){
            right_or |= nums[right];
            while(left <= right && (nums[left] | right_or) > k){
                ans = min(ans, (nums[left] | right_or) - k);
                left++;
                if(bottom < left){
                    for(int i = right - 1; i >= left; i--){
                        nums[i] |= nums[i + 1];
                    }
                    bottom = right;
                    right_or = 0;
                }

            }
            if(left <= right){
                ans = min(ans,  k - (nums[left] | right_or));
            }
            
        }
        return ans;
        
    }
};
// @lc code=end

