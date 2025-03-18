/*
 * @lc app=leetcode.cn id=81 lang=cpp
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int turn = -1;
        if(target == nums[0]){
            return true;
        }
        
        for(int i = 0; i < nums.size() - 1; i++){
            if(nums[i] == target){
                return true;
            }

            if(nums[i] > nums[i + 1]){
                turn = i;
            }
        }
        
        int left = turn + 1;
        if(turn == -1){
            left = 0;
        }
        int right = nums.size() - 1;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
        
        
    }
};
// @lc code=end

