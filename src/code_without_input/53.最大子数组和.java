/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int dp = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp = dp < 0 ? nums[i] : (dp + nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}
// @lc code=end

