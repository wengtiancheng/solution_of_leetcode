package array;

class leetcode27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int[] tmp = new int[len];
        int count = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] != val){
                tmp[count] = i;
                count++;

            }
        }
        for(int j = 0; j < count; j++){
            nums[j] = nums[tmp[j]];
        }
        return count;


    }
}