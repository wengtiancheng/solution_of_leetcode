/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int ansLeft = -1;
        int ansRight = s.length();
        char[] chars = t.toCharArray();
        //tmp[char]表示t中某字母的数量和字串中对应字母的差值
        int[] tmp = new int[128];
        //less表示目前字串中有less中字母，它们出现的次数小于t中对应字母出现的次数
        int less = 0;
        for(char ch : chars){
            if(tmp[ch] == 0){
                less++;
            }
            tmp[ch]++;
        }
        int right = 0;
        int left = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            tmp[c]--;
            if(tmp[c] == 0){
                less--;
            }
            if(less == 0){
                char d = s.charAt(left);
                while(tmp[d] < 0){
                    left++;
                    tmp[d]++;
                    d = s.charAt(left);
                }
                if(ansRight - ansLeft > right - left){
                    ansRight = right;
                    ansLeft = left;
                }
            }
            right++;
        }
        if(ansLeft == -1){
            return "";
        }else{
            return s.substring(ansLeft, ansRight + 1);
        }
    }
}
// @lc code=end

