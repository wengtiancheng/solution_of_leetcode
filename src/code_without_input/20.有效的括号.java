/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        boolean res = true;
        Stack<Character> tmp = new Stack<>();
        char[] chs = s.toCharArray();
        for(char ch : chs){
            if(ch == '(' || ch == '{' || ch == '['){
                tmp.push(ch);
            }else if(ch == ')'){
                if(tmp.isEmpty() || tmp.pop() != '('){
                    return false;
                }
            }else if(ch == '}'){
                if(tmp.isEmpty() || tmp.pop() != '{'){
                    return false;
                }
            }else if(ch == ']'){
                if(tmp.isEmpty() || tmp.pop() != '['){
                    return false;
                }
            }
        }
        if(tmp.isEmpty()){
            return true;
        }
        return false;
    }
}
// @lc code=end

