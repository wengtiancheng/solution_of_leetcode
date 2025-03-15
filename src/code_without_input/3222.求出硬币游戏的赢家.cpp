/*
 * @lc app=leetcode.cn id=3222 lang=cpp
 *
 * [3222] 求出硬币游戏的赢家
 */

// @lc code=start
#include <string>
using namespace std;
class Solution {
public:
    string losingPlayer(int x, int y) {
        int res = 0;
        while(x >= 1 && y >= 4){
            x -= 1;
            y -= 4;
            res = !res;
        }
        if(res){
            return "Alice";
        }
        return "Bob";
        
    }
};
// @lc code=end

