/*
 * @lc app=leetcode.cn id=438 lang=cpp
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> standard(26);
        vector<int> ans;
        vector<int> tmp(26);
        int len = p.size();
        int slen = s.size();
        if(slen < len){
            return vector<int>();
        }
        for(int i = 0; i < len; i++){
            standard[p[i] - 'a']++;
            tmp[s[i] - 'a']++;
        }
        if(standard == tmp){
            ans.emplace_back(0);
        }
        

        for(int i = 0; i < slen - len; i++){
            tmp[s[i] - 'a']--;
            tmp[s[i + len] - 'a']++;
            if(tmp == standard){
                ans.emplace_back(i + 1);
            }
        }
        return ans;


    }
};
// @lc code=end

