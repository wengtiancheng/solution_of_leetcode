/*
 * @lc app=leetcode.cn id=56 lang=cpp
 *
 * [56] 合并区间
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];  // 按照起始位置升序排序
        });
        
        vector<vector<int>> res;
        
        // 遍历每个区间
        for (const auto& interval : intervals) {
            // 如果结果集为空，或者当前区间的起始位置大于上一个区间的结束位置，直接添加
            if (res.empty() || res.back()[1] < interval[0]) {
                res.push_back(interval);
            } else {
                // 否则，合并区间
                res.back()[1] = max(res.back()[1], interval[1]);
            }
        }
        
        return res;
    }
};
// @lc code=end

