/*
 * @lc app=leetcode.cn id=42 lang=cpp
 *
 * [42] 接雨水
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int trap(vector<int>& height) {
        /*
            每个节点所能接受的雨水量等于它左右两边节点的最大值的最小值
            因此需要构建两个数组，分别表示每个节点左边高度的最大值和右边高度的最大值
            对于左边高度的最大值，可以正向遍历数组，leftmax[i] = max(leftmax[i - 1], height[i]),递推的开始leftmax[0] = height[0],
            对于右边高度的最大值，反向遍历数组，过程也差不多
            然后再取两者的最小值，就等于在这个节点上水面的高度
        */
        
        int len = height.size();
        vector<int> leftmax(len);
        vector<int> rightmax(len);
        leftmax[0] = height[0];
        rightmax[len - 1] = height[len - 1];
        for(int i = 1; i < len; i++){
            leftmax[i] = max(leftmax[i - 1], height[i]);
        }
        for(int i = len - 2; i >= 0; i--){
            rightmax[i] = max(rightmax[i + 1], height[i]);
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += min(leftmax[i], rightmax[i]) - height[i];
        }
        return sum;
    }
};
// @lc code=end

