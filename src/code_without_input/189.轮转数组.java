/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int[] tmp = Arrays.copyOf(nums, len);
        for(int i = 0; i < k; i++){
            nums[i] = tmp[len - k + i];
        }
        for(int i = k; i < len; i++){
            nums[i] = tmp[i - k];
        }
    }
}
// @lc code=end

