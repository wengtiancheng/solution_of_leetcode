/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(tmp.containsKey(target - nums[i])){
                return new int[]{i, tmp.get(target - nums[i])};
            }else{
                tmp.put(nums[i], i);
            }
        }
        return null;
    }
}
// @lc code=end

