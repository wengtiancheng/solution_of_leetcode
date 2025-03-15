/*
 * @lc app=leetcode.cn id=376 lang=cpp
 *
 * [376] 摆动序列
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int len = nums.size();
        int max = 1;
        for(int i = 0; i < len - 2; i++){
            int len = 0;
            for(int j = i; j < len - 2; j++){
                if((nums[j + 1] - nums[j]) * (nums[j + 1] - nums[j + 2]) > 0){

                }

            }
        }
        
    }
};
// @lc code=end

