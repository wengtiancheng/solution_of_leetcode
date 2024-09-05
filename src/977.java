import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            Double tmp = Math.pow(nums[i], 2);
            nums[i] = tmp.intValue();
        }
        for(int i = 0 ; i < len; i++){
            for(int j = len - 2; j >= i; j--){
                if(nums[j] > nums[j + 1]){
                    int tmp =  nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }
    public int[] solution2(int[] nums) {
        int len = nums.length;
        int ptr = len - 1;
        int[] tmp = new int[ptr + 1];
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int ln = nums[left] * nums[left];
            int rn = nums[right] * nums[right];
            if(ln < rn){
                tmp[ptr] = rn;
                right--;
            }else{
                tmp[ptr] = ln;
                left++;
            }
            ptr--;
        }
        return tmp;

    }
}