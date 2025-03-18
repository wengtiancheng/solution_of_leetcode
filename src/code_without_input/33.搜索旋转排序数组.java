/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int turn = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                turn = i + 1;
            }
        }
        int left, right;
        if(target >= nums[0]){
            left = 0;
            right = turn == 0 ? nums.length - 1 : turn;
        }else{
            left = turn;
            right = nums.length - 1;
        }
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

