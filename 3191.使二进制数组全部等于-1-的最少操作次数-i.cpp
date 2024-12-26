/*
 * @lc app=leetcode.cn id=3191 lang=cpp
 *
 * [3191] 使二进制数组全部等于 1 的最少操作次数 I
 */

// @lc code=start
#include <vector>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums) {
        int len = nums.size();
        int count = 0;
        for(int i  = 0 ; i <= len - 3; i++){
            if(nums[i] == 0){
                nums[i] = 1;
                nums[i + 1] = !nums[i + 1];
                nums[i + 2] = !nums[i + 2];
                count++;
            }
        }
        if(nums[len - 2] == 1 && nums[len - 1] == 1){
            return count;
        }else{
            return -1;
        }
        
    }
};
// @lc code=end

