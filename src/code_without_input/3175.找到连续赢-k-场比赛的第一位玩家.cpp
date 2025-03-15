/*
 * @lc app=leetcode.cn id=3175 lang=cpp
 *
 * [3175] 找到连续赢 K 场比赛的第一位玩家
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int findWinningPlayer(vector<int>& skills, int k) {
        int count = 0;
        int max = skills[0];
        for(int i = 1; i < skills.size(); i = (i + 1) % skills.size()){
            if(skills[i] > max){
                max = skills[i];
                count = 1;
            }else{
                count++;
            }
            if(count == k){
                return max == skills[0] ? 0 : i - k + 1;
            }
        }
        return -1;
       
        
    }
    
};
// @lc code=end

