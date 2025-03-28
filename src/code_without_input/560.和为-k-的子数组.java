/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    //sum[i]为从nums[0]到nums[i]的和
    //如果从num[j]到nums[i]的和为k
    //那么sum[i] - sum[j - 1] = k
    //即sum[j - 1] = sum[i] - k
    //因此我们只需要维护一个sum[i]，再将之前的所有sum[j]添加到一个hashmap中
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(0, 1);
        int res = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            res += tmp.getOrDefault(sum - k, 0);
            tmp.put(sum, tmp.getOrDefault(sum, 0) + 1);
        }
        return res;

        
    }
}
// @lc code=end

