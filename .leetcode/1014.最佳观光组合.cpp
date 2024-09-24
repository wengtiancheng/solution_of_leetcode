#include <vector>
#include <algorithm>
using namespace std;
/*
 * @lc app=leetcode.cn id=1014 lang=cpp
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
//枚举右，维护左
class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        int len = values.size();
        int ans = 0;
        int mx = values[0] + 0;
        for(int i = 1; i < len; i++){
            ans = max(ans, mx + values[i] - i);
            mx = max(mx, values[i] + i);
        }
        return ans;
    }
};
// @lc code=end

