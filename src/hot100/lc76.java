package hot100;/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Scanner;


class lc76 {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int min_len = Integer.MAX_VALUE;
        //用valid表示当前窗口中有几种字符满足t对应字符的数量，如果都满足的话，滑动窗口就可以开始减小了
        int valid = 0;
        int start = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            
            //都满足的话，窗口可以开始减小
            if(valid == need.size()){
                while(left < right){
                    c = s.charAt(left);
                    if(!need.containsKey(c)){
                        left++;
                    }else if(window.get(c) > need.get(c)){
                        left++;
                        window.put(c, window.get(c) - 1);
                    }else if(window.get(c).equals(need.get(c))){
                        if(right - left + 1 < min_len){
                            min_len = right - left + 1;
                            start = left;
                        }
                        valid--;
                        left++;
                        window.put(c, window.get(c) - 1);
                        break;
                    }
                }
            }
            right++;

        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(start, start + min_len);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        String t = "";
        if(sc.hasNextLine()){
            s = sc.nextLine();
        }
        if(sc.hasNextLine()){
            t = sc.nextLine();
        }
        System.out.println(minWindow(s, t));
    }
}
// @lc code=end

