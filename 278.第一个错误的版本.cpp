/*
 * @lc app=leetcode.cn id=278 lang=cpp
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
// The API isBadVersion is defined for you.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        long long left = 1;
        long long right = n;
        long long mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(isBadVersion(mid)){
                if(!isBadVersion(mid - 1)){
                    return mid;
                }else{
                    right = mid - 1;
                }
            }else{
                if(isBadVersion(mid + 1)){
                    return mid + 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return 0;
        
    }
};
// @lc code=end

