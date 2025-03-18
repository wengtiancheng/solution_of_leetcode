/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    //tail[i],i是长度，表示在所有长度为i的递增子序列的最后一个数字中，最小的那一个
    //为了使递增子序列的长度尽可能大，最后一个数字要尽可能小，就是贪心算法
    //初始tail[1] = nums[0]
    //最长长度就1
    //然后用Long表示当前子序列所能达到的最大值
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        //推理可知tail是严格递增的
        int[] tail = new int[len + 1];
        tail[1] = nums[0];
        int max = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] > tail[max]){
                //大于目前最长的子序列的末尾的值，子序列的长度可以加一
                max++;
                tail[max] = nums[i];
            }else{
                //发现了某个上升子序列的更小的末尾元素，需要更新它
                int left = 1;
                int right = max;
                int pos = 0;
                int mid;
                while(left <= right){
                    mid = (left + right) / 2;
                    if(tail[mid] < nums[i]){
                        pos = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                tail[pos + 1] = nums[i];
            }
        }
        return max;
       
    }
}
// @lc code=end

