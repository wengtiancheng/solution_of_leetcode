/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //构建两个数组l和r，表示某一位元素左边所有元素的乘积和右边所有元素的乘积
        //这种构建和遍历方式有点像接雨水的那一题
        int len = nums.length;
        int[] l = new int[len];
        //返回的结果不在空间复杂度之内
        //可以先将返回结果作为L数组使用
        //然后用一个变量来作为r数组，在反向遍历的时候不断更新
        l[0] = 1;
        
        for(int i = 1; i < len; i++){
            l[i] = l[i - 1] * nums[i - 1];
        }
        int r = 1;
        for(int i = len - 1; i >= 0; i--){
            l[i] *= r;
            r *= nums[i];
        }
        return l;
        
    }
}
// @lc code=end

