#include <vector>
#include <string>
using namespace std;
/*
 * @lc app=leetcode.cn id=1436 lang=cpp
 *
 * [1436] 旅行终点站
 */

// @lc code=start

class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        int len = paths.size();
        for(int i = 0; i < len; i++){
            bool found = false;
            for(int j = 0; j < len; j++){
                if(paths[i][1] == paths[j][0]){
                    found = true;
                    break;
                }
            }
            if(found == false){
                return paths[i][1];
            }
        }
        return "";

    }
};
// @lc code=end

