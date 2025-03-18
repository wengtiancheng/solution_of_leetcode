/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, max_len = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);      // 以单个字符为中心（奇数长度）
            int len2 = expandAroundCenter(s, i, i + 1);  // 以两个字符间隙为中心（偶数长度）
            int len = Math.max(len1, len2);
            if (len > max_len) {
                max_len = len;
                start = i - (len - 1) / 2;  // 计算起点
            }
        }
        return s.substring(start, start + max_len);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;  // 计算当前回文串长度
    }
}
// @lc code=end

