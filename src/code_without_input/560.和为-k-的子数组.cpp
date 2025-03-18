/*
 * @lc app=leetcode.cn id=560 lang=cpp
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int sum = 0;
        int len = nums.size();
        int count = 0;
        for(int i = 0; i < len; i++){
            sum = 0;
           for(int j = i; j < len; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
           } 
        }
        return count;
    }
};
// @lc code=end

