/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        
        left[0] = 1;
        int right = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            left[i] *= right;
            right *= nums[i];
        }
        
        return left;
    }
}
// @lc code=end

