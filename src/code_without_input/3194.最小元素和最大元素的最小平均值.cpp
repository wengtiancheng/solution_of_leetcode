#include <vector>
#include <algorithm>
using namespace std;
/*
 * @lc app=leetcode.cn id=3194 lang=cpp
 *
 * [3194] 最小元素和最大元素的最小平均值
 */

// @lc code=start

class Solution {
public:
    double minimumAverage(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int len =  nums.size();
        int left = 0;
        int right = len - 1;
        vector<double> res(len / 2);
        int ptr = 0;
        while(ptr < len / 2){
            res[ptr] = 1.0 * (nums[left] + nums[right]) / 2;
            ptr++;
            left++;
            right--;
        }
        sort(res.begin(), res.end());
        return res[0];
        
    }
};
// @lc code=end

