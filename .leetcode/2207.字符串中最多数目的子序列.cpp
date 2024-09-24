#include <string>
#include <vector>
using namespace std;
/*
 * @lc app=leetcode.cn id=2207 lang=cpp
 *
 * [2207] 字符串中最多数目的子序列
 */

// @lc code=start


class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        char a = pattern[0];
        char b = pattern[1];
        long long len = text.length();
long long count_a = 0;
long long count_b = 0;
long long sum = 0;
if(a != b){
    for(long long i = 0; i < len; i++){
        if(text[i] == a){
            count_a++;
        }else if(text[i] == b){
            count_b++;
            sum += count_a;
        }
    }
    return count_a > count_b ? sum + count_a : sum + count_b;
}else{
    for(long long i = 0; i < len; i++){
        if(text[i] == a){
            sum++;
        }
    }
    if(sum == 0){
        return 0;
    }else{
        long long res = 1;
        while(sum > 0){
            res *= sum;
            sum--;
        }
        return res;
    }
}
            
        }
       
        

    
    
};

// @lc code=end

