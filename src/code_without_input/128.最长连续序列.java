/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for(int num : nums){
            tmp.add(num);
        }
        int max = 0;
        for(int num : tmp){
            if(tmp.contains(num - 1)){
                continue;
            }else{
                
                int next = num + 1;
                while(tmp.contains(next)){
                    
                    next++;
                }
                max = Math.max(max, next - num);
            }
        }
        return max;
    }
}
// @lc code=end

