/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
#include <string>
#include <unordered_set>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> tmp;
        int start = 0;
        int end = 0;
        int max = 0;
        int current = 0;
        int len = s.size();
        
        while(end < len){
            
            if(!tmp.count(s[end])){
                tmp.insert(s[end]);
                current++;
                if(current > max){
                    max = current;
                }
                end++;
            }else{
                tmp.erase(s[start]);
                start++;
                current--;
            }
        }
        return max;
        
    }
};
// @lc code=end

