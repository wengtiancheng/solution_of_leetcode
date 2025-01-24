/*
 * @lc app=leetcode.cn id=2944 lang=cpp
 *
 * [2944] 购买水果需要的最少金币数
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int minimumCoins(vector<int>& prices) {
        int n = prices.size();
        vector<int> memo((n + 1) / 2);
        auto dfs = [&](this auto&& dfs, int i) -> int {
            if (i * 2 >= n) {
                return prices[i - 1]; // i 从 1 开始
            }
            int& res = memo[i]; // 注意这里是引用
            if (res) { // 之前算过
                return res;
            }
            res = INT_MAX;
            for (int j = i + 1; j <= i * 2 + 1; j++) {
                res = min(res, dfs(j));
            }
            res += prices[i - 1];
            return res;
        };
        return dfs(1);
    }
};


// @lc code=end

