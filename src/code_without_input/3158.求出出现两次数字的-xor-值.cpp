/*
 * @lc app=leetcode.cn id=3158 lang=cpp
 *
 * [3158] 求出出现两次数字的 XOR 值
 */

// @lc code=start
#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int duplicateNumbersXOR(vector<int>& nums) {
        int len = nums.size();
        int res = 0;
        vector<int> arr(51, 0);
        for(int i = 0; i < len; i++){
            arr[nums[i]]++;
        }
        for(int i = 0; i < 51; i++){
            if(arr[i] == 2){
                res = res ^ i;
            }
        }
        return res;
        
    }
};
// @lc code=end

