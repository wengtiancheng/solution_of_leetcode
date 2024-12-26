/*
 * @lc app=leetcode.cn id=455 lang=cpp
 *
 * [455] 分发饼干
 */

// @lc code=start
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int len1 = g.size() - 1;
        int len2 = s.size() - 1;
        int count = 0;
        while(len1 >= 0 && len2 >= 0){
            if(s[len2] >= g[len1]){
                count++;
                len1--;
                len2--;
                
            }else{
                len1--;
            }
        }
        return count;

    }
};
// @lc code=end

