/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left_max = new int[len];
        left_max[0] = 0;
        int[] right_max = new int[len];
        right_max[len - 1] = 0;
        for(int i = 1; i < len; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }
        for(int i = len - 2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            int h = Math.min(left_max[i], right_max[i]);
            if(h > height[i]){
                sum += h - height[i];
            }
        }
        return sum;
    }
}
// @lc code=end

