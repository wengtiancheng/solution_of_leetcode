/*
 * @lc app=leetcode.cn id=3216 lang=cpp
 *
 * [3216] 交换后字典序最小的字符串
 */

// @lc code=start
#include <string>
using namespace std;

class Solution {
public:
    string getSmallestString(string s) {
        int len = s.size();
        for(int i = 0; i < len - 1; i++){
            if(((s[i] - '0') % 2) == (((s[i + 1] - '0') % 2))){
                if(s[i] > s[i + 1]){
                    char tmp = s[i];
                    s[i] =  s[i + 1];
                    s[i + 1] = tmp;
                    return s;
                }
            }
        }
        return s;
        
    }
};
// @lc code=end

 