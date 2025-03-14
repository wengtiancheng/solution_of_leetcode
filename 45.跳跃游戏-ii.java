/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int step = 0;    //当前的跳跃步数
        int end = 0;     //这次跳跃的边界
        int farthest = 0; //目前能到达的最远位置
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == end){
                step++;
                end = farthest;
            }
        }
        return step;
    }
}

// @lc code=end

