import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            Double tmp = Math.pow(nums[i], 2);
            nums[i] = tmp.intValue();
        }
        nums
    }
}