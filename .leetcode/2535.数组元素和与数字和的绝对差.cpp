
/*
 * @lc app=leetcode.cn id=2535 lang=cpp
 *
 * [2535] 数组元素和与数字和的绝对差
 */

// @lc code=start
#include <vector>
#include <cmath>
using namespace std;
class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        int sum = 0;
        int pos_sum = 0;
        int len =  nums.size();
        for(int i = 0; i < len; i++){
            sum += nums[i];
            int tmp = nums[i];
            while(tmp > 0){
                pos_sum += tmp % 10;
                tmp /= 10;
            }
        }
        return abs(sum - pos_sum);
        
    }
};
// @lc code=end

