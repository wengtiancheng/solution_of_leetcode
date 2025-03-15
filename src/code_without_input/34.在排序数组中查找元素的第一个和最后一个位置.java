/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    int first = 100001;
    int last = -1;
    boolean find = false;
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        search(nums, target, 0, len - 1);
        if(find){
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }
    public void search(int[] nums, int target, int begin, int end){
        if(begin > end){
            return;
        }
        int mid = (begin + end) / 2;
        if(nums[mid] == target){
            find = true;
            if(mid < first){
                first = mid;
            }
            if(mid > last){
                last = mid;
            }
            search(nums, target, mid + 1, end);
            search(nums, target, begin, mid - 1);
        }else if(nums[mid] > target){
            search(nums, target, begin, mid - 1);
        }else{
            search(nums, target, mid + 1, end);
        }
    }
}
// @lc code=end

