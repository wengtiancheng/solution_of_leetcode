package daily_code;

import java.util.Arrays;
import java.util.List;

class lc2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int c = 0;
        for(List<Integer> i : nums){
            c = Math.max(c, i.get((1)));
        }
        int[] count = new int[c + 1];
        for(List<Integer> i : nums){
            for(int j = i.get(0); j <= i.get(1); j++){
                count[j]++;
            }
        }
        int ans = 0;
        for(int i  = 1; i <= c; i++){
            if(count[i] > 0){
                ans++;
            }
        }
        return ans;

    }
}