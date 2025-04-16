/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for(int num : nums){
            if(tmp.contains(num)){
                tmp.remove(num);
            }else{
                tmp.add(num);
            }
        }
        return tmp.iterator().next();
    }
}
// @lc code=end

