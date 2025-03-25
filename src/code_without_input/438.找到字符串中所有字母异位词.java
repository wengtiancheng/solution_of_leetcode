/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<>();
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0; i < p.length(); i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if(Arrays.equals(pCount,sCount)){
            res.add(0);
        }
        for(int right = p.length(); right < s.length(); right++){
            sCount[s.charAt(right) - 'a']++;
            sCount[s.charAt(right - p.length()) - 'a']--;
            if(Arrays.equals(sCount, pCount)){
                res.add(right - p.length() + 1);
            }
        }
        return res;
        
    }
}
// @lc code=end

