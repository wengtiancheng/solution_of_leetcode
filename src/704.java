class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(target < nums[0] || target > nums[len - 1]){
            return -1;
        }
        int left = 0;
        int right = len - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;

            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;





    }
}