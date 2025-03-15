/*
 * @lc app=leetcode.cn id=350 lang=cpp
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
#include <vector>
#include <unordered_map>
using namespace std;
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return intersect(nums2, nums1);
        }
        unordered_map<int, int> res;
        int len1 = nums1.size();
        int len2 = nums2.size();
        for(int i = 0; i < len1; i++){
            res[nums1[i]]++;
        }
        vector<int> tmp;
        for(int i = 0; i < len2; i++){
            if(res[nums2[i]] > 0){
                tmp.push_back(nums2[i]);
                res[nums2[i]]--;
            }
        }
        return tmp;
    }
};
// @lc code=end

