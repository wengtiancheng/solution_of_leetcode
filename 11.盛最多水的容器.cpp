/*
 * @lc app=leetcode.cn id=11 lang=cpp
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
       int max_v = -1;
       int current_v = 0;
       int left = 0;
       int right = height.size() - 1;
       while(left < right){
        current_v = (right - left) * min(height[left], height[right]);
        max_v = max(max_v, current_v);

        if(height[left] < height[right]){
            left++;
        }else{
            right--;
        }
       }
       return max_v;
    }
};
// @lc code=end

