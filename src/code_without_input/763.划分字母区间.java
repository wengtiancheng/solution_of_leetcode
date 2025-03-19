/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start


import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        int[] lastIndex = new int[26]; 
        int len = s.length();
        for(int i = 0; i < len; i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int ptr = 0;
        int end = 0;
        int count = 0;
        while(ptr < len){
            end = Math.max(end, lastIndex[s.charAt(ptr) - 'a']);
            ptr++;
            count++;
            if(ptr == end + 1){
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}
// @lc code=end

