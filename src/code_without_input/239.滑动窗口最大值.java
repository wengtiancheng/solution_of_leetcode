/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.*;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> tmp = new LinkedList<Integer>();
        for(int i = 0; i < len; i++){
            //先剔除已经不在窗口中的元素
            while(!tmp.isEmpty() && tmp.peekFirst() <= i - k){
                tmp.pollFirst();
            }
            //删除那些既在前面又小于nums[i]的值，因为它们永远也不会成为滑动窗口的最大值
            while(!tmp.isEmpty() && nums[tmp.peekLast()] < nums[i]){
                tmp.pollLast();
            }
            //再将新的nums[i]加进去，此时它的前面只有比它大的
            tmp.offerLast(i);
            //将最大值加入结果中
            if(i >= k - 1){
                res[i - k + 1] = nums[tmp.peekFirst()];
            }

        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        if(sc.hasNextLine()){
            s = sc.nextLine();
        }
        if(sc.hasNextLine()){
            t = sc.nextLine();
        }
        System.out.println(maxSlidingWindow());
    }

    
}


// @lc code=end

