/*
 * @lc app=leetcode.cn id=3184 lang=cpp
 *
 * [3184] 构成整天的下标对数目 I
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int countCompleteDayPairs(vector<int>& hours) {
        int len = hours.size();
        vector<int> res(24, 0);
        for(int i = 0; i < len; i++){
            res[hours[i] % 24]++;
        }
        int sum = 0;
        for(int i = 1; i < 12; i++){
            sum += res[i] * res[24 - i];

        }
        sum += C(res[0], 2);
        sum += C(res[12], 2);
        return sum;
        
    }
    long long C(int m, int n) {
        if (n > m) return 0;
        long long result = 1;
        for (int i = 0; i < n; ++i) {
            result = result * (m - i) / (i + 1);
        }
        return result;
    }
};
// @lc code=end

