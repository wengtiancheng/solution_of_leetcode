/*
 * @lc app=leetcode.cn id=3162 lang=cpp
 *
 * [3162] 优质数对的总数 I
 */

// @lc code=start
#include <vector>
using namespace std;
class Solution {
public:
    int numberOfPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        for(int i = 0; i < len2; i++){
            nums2[i] *= k;
        }
        int count = 0;
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

