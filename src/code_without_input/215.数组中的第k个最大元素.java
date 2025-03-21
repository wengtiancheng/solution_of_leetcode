/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
package code_without_input;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int quickSort(int[] nums, int left, int right, int k){
        if(left >= right){
            return -1;
        }
        int pos = partition(nums, left, right);
        if(nums.length - pos == k){
            return nums[pos];
        }else if(nums.length - pos > k){
            return quickSort(nums, pos + 1, right, k);
        }else{
            return quickSort(nums, left, pos - 1, k);
        }


    }
    public int partition(int[] nums, int left, int right){
        int ptr_1 = left;
        int ptr_2 = right;
        int base = nums[left];
        while(ptr_1 < ptr_2){
           do {
               ptr_1++;
           }while (nums[ptr_1] <= base);
           do {
               ptr_2++;
           }while(nums[ptr_2] >= base);
           int tmp = nums[ptr_1];
           nums[ptr_1] = nums[ptr_2];
           nums[ptr_2] = tmp;
        }
        nums[ptr_1] = base;
        return ptr_1;

    }
}


// @lc code=end

