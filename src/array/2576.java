import java.lang.reflect.Array;
import java.util.Arrays;

class lc2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0;
        int r = len / 2;
        while(l < r){
            int m = (l + r + 1) / 2;
            if(check(nums, m)){
                l = m;
            }else{
                r = m;
            }
        }
        return 2 * l;
    }
    public boolean check(int[] nums, int m){
        int len = nums.length;
        for(int i = 0; i < m; i++){
            if(nums[i] * 2 > nums[len - 1 - i]){
                return false;
            }
        }
        return true;
    }
}