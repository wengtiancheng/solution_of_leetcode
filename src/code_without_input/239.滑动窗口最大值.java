/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.*;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> tmp = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            while(!tmp.isEmpty() && tmp.peekFirst() <= i - k){
                tmp.pollFirst();
            }
            while(!tmp.isEmpty() && tmp.peekLast() < nums[i]){
                tmp.pollLast();
            }
            tmp.addLast(i);
            if(i >= k - 1){
                res[i - k + 1] = nums[tmp.peekFirst()];
            }
            
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        int t;
        if(sc.hasNextLine()){
            s = sc.nextLine();
            String[] strs = s.split(" ");
            int[] nums = new int[strs.length];
            for(int i = 0; i < strs.length; i++){
                nums[i] = Integer.parseInt(strs[i]);
            }
            t = sc.nextInt();
            System.out.println(maxSlidingWindow(nums, t));
        }
        
    }

    
}


// @lc code=end

