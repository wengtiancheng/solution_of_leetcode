/*
 * @lc app=leetcode.cn id=3066 lang=cpp
 *
 * [3066] 超过阈值的最少操作数 II
 */

// @lc code=start
#include <vector>

using namespace std;
class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
         priority_queue<long long, vector<long long>, greater<>> pq;
        for (int x : nums) {
            pq.push((long long) x);
        }

        int ans = 0;
        while (pq.top() < k) {
            long long x = pq.top(); pq.pop();
            long long y = pq.top(); pq.pop();
            pq.push(x * 2 + y);
            ans++;
        }
        return ans;
    }


};
// @lc code=end

