/*
 * @lc app=leetcode.cn id=3164 lang=cpp
 *
 * [3164] 优质数对的总数 II
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    long long numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        for(int i = 0; i < len2; i++){
            nums2[i] *= k;
        }
        long long count = 0;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(nums1[i] % nums2[j] == 0){
                    count++;
                }
            }
        }
        return count;
        
    }
};
// @lc code=end

