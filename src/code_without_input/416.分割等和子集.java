/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        int len = nums.length;
        if(len < 2){
            return false;
        }
        for(int i = 0; i < len; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        if(max > target){
            return false;
        }
        //定义二维布尔数组dp,n行target + 1列
        //dp[i][j]表示从[0, i]中选取任意个数字（可以为0个），是否可以使结果为j
        //递归的基本条件，对于所有的i，都可以一个都不选，使得结果为0，因此dp[i][0] = true
        //递归的基本条件，dp[0][nums[0]] = true;同一行的其他的都为false
        // boolean[][] dp = new boolean[len][target + 1];
        // for(int i = 0; i <= target; i++){
        //     if(i != nums[0]){
        //         dp[0][i] = false;
        //     }else{
        //         dp[0][i] = true;
        //     }
        // }
        // for(int i = 0; i < len; i++){
        //     dp[i][0] = true;
        // }
        // //递归的递推条件，dp[i][j]是否为真，可以通过nums[i]与j的大小关系来区分，下面直接用代码来展示
        // for(int i = 1; i < len; i++){
        //     for(int j = 1; j <= target; j++){
        //         if(nums[i] <= j){
        //             //算了它不会超过j，因此带不带它都有可能
        //             dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        //         }else{
        //             //它自己就超过j了，因此肯定不能带它
        //             dp[i][j] = dp[i - 1][j];
        //         }
        //     }
        // }
        // return dp[len - 1][target];

        //二维数组的下面一行只和上面一行关联，因此也可以降为一维，在遍历时不断更新
        //先填入第0行的相关数据
        boolean[] dp = new boolean[target + 1];
        for(int i = 0; i <= target; i++){
            if(i != nums[0]){
                dp[i] = false;
            }else{
                dp[i] = true;
            }
        }
        //然后从第一行开始向下迭代
        for(int i = 1; i < len; i++){
            //注意dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            //因此在遍历列的时候从后往前遍历，不然列数小的先被修改了
            for(int j = target; j >= 0; j--){
                if(nums[i] <= j){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];

        
    }
}
// @lc code=end

