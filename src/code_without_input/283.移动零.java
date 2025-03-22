/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        //左指针指向处理好序列的尾部
        //右指针指向待处理序列的头部

        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        
    }
    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
// @lc code=end

