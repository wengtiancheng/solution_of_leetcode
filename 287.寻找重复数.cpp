/*
 * @lc app=leetcode.cn id=287 lang=cpp
 *
 * [287] 寻找重复数
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int len = nums.size();
        int left = 1;
        int right = len - 1;
        int mid;
        int res;
        while(left <= right){
            int cnt = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < len; i++){
                cnt += nums[i] <= mid;
            }
            if(cnt <= mid){
                left = mid + 1;
            }else{
                right = mid - 1;
                res = mid;
            }
        }
        return mid;
        
    }
};
// @lc code=end

