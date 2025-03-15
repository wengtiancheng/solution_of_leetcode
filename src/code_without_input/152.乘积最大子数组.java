/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        //dp_max[i]表示以nums[i]结尾的子数组的乘积的最大值
        //相似地，另外一个表示乘积的最小值
        int dp_max = nums[0];
        int dp_min = nums[0];
        int max = nums[0];
        for(int i = 1; i < len; i++){
            int dm = dp_max;
            int dn = dp_min;
            dp_max = Math.max(dm * nums[i], Math.max(dn * nums[i], nums[i]));
            dp_min = Math.min(dn * nums[i], Math.min(dm * nums[i], nums[i]));
            if(dp_max > max){
                max = dp_max;
            }
        }
        return max;
    }
}
// @lc code=end

