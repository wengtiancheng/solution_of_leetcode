/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    //明确的思路，找到第一个大于或者等于target的下标
    //这样既考虑到了找到的情况，也考虑到没找到的情况
    
    public int searchInsert(int[] nums, int target) {
        
        int len = nums.length;
        int pos = len;
        int left = 0, right = len - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(target <= nums[mid]){
                pos = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return pos;


    }
    
}
// @lc code=end

