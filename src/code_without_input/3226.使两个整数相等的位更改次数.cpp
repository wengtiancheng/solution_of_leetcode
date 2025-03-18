/*
 * @lc app=leetcode.cn id=3226 lang=cpp
 *
 * [3226] 使两个整数相等的位更改次数
 */

// @lc code=start
#include <string>
#include <math.h>
using namespace std;
class Solution{

public:
    int minChanges(int n, int k) {
        if(n == k){
            return 0;
        }
        string str1 = tenToTwo(n);
        string str2 = tenToTwo(k);
        int len1 = str1.size();
        int len2 = str2.size();
        int ptr1 = len1 - 1;
        int ptr2 = len2 - 1;
        int count = 0;
        while(ptr1 >= 0 && ptr2 >= 0){
            if(str1[ptr1] == str2[ptr2]){
               
            }else if(str1[ptr1] == '1'){
                count++;
                
            }else{
                return -1;
            }
            ptr1--;
            ptr2--;
        }
        if(ptr2 >= 0){
            return -1;
        }else if(ptr1 >= 0){
            while(ptr1 >= 0){
                if(str1[ptr1] == '1'){
                    count++;
                }
                ptr1--;
                
            }
            return count;
        }
        return count;
        
    }

    string tenToTwo(int n){
        if(n == 0){
            return "0";
        }
        string res = "";
        while(n > 0){
            res = (n % 2 == 0 ? "0" : "1") + res;
            n /= 2;
        }
        return res;

    }
};
// @lc code=end

