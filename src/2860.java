import java.util.Collections;
import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int len = nums.size();
        int num_of_choice = 0;
        if(nums.get(0) > 0){
            num_of_choice++;
        }
        if(nums.get(len - 1) < len){
            num_of_choice++;
        }
        for(int i = 1; i < len; i++) {
           if(nums.get(i - 1) < i && nums.get(i) > i){
               num_of_choice++;
           }
        }
        return num_of_choice;

    }
}