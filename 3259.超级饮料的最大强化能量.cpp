/*
 * @lc app=leetcode.cn id=3259 lang=cpp
 *
 * [3259] 超级饮料的最大强化能量
 */

// @lc code=start
#include <vector>
#include <algorithm>

using namespace std;
class Solution {
public:
    long long maxEnergyBoost(vector<int>& energyDrinkA, vector<int>& energyDrinkB) {
        int len = energyDrinkA.size();
        vector<vector<int>> dP(len, vector<int>{0, 0});
        dP[1][0] = energyDrinkA[0];
        dP[1][1] = energyDrinkB[0];
        dP[2][0] = dP[1][0] + energyDrinkA[1];
        dP[2][1] = dP[1][1] + energyDrinkB[1];
        for(int i = 3; i <= len; i++){
            dP[i][0] = max(dP[i - 1][0], dP[i - 2][1]) + energyDrinkA[i - 1];
            dP[i][1] = max(dP[i - 1][1], dP[i - 2][0]) + energyDrinkB[i - 1];

        }
        return max(dP[len][0], dP[len][1]);
        
    }
};
// @lc code=end

