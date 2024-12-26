/*
 * @lc app=leetcode.cn id=3254 lang=cpp
 *
 * [3254] 长度为 K 的子数组的能量值 I
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> resultsArray(vector<int>& nums, int k) {
        int len = nums.size();
        if(k == 1){
            return nums;
        }
        vector<int> res(len - k + 1, -1);
        int base = nums[0];
        int valid = 0;
        for(int i = 1; i < k; i++){
            if(nums[i] == base + i){

            }else{
                valid = i;
                break;
            }
        }
        res[0] = valid == 0 ? nums[k - 1] : -1;
        int ptr = 1;
        while(ptr <= len - k){
            if(ptr < valid){
                res[ptr] = -1;
                ptr++;
            }else if(ptr == valid){
                int base = nums[ptr];
                for(int i = ptr; i < ptr + k; i++){
                    if(nums[i] == base + i - ptr){

                    }else{
                        valid = i;
                        break;
                    }

                }
                res[ptr] = valid == ptr ? nums[ptr + k - 1] : -1;
                ptr++;
            }else if(ptr > valid){
                if(nums[ptr + k - 1] == nums[ptr + k - 2] + 1){
                    res[ptr] = nums[ptr + k - 1];
                }else{
                    res[ptr] = -1;
                    valid = ptr + k - 1;
                }
                ptr++;
            }
        }
        return res;
        
    }
};
// @lc code=end

