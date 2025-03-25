/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int right = 0;
        int left = 0;
        int max_len = 1;
        Map<Character, Integer> tmp = new HashMap<>();
        char[] chars = s.toCharArray();
        tmp.put(chars[0], 0);
        while(right < chars.length - 1){
            right++;
            if((tmp.containsKey(chars[right]))){
                left = Math.max(left, tmp.get(chars[right]) + 1);
            }
            tmp.put(chars[right], right);
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}
// @lc code=end

