/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        //利用hashset来提升查询效率
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
    
}
// @lc code=end

