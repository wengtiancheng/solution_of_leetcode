/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum < -1 * nums[i]){
                    left++;
                }else if(sum > -1 * nums[i]){
                    right--;
                }else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(nums[left - 1] == nums[left] && left < right){
                        left++;
                    }
                    while(nums[right + 1] == nums[right] && left < right){
                        right--;
                    }
                    
                }
            }
        }
        return res;
    }
}
// @lc code=end

