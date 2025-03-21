package hot100;

import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;

public class lc153 {
    public static int findMin(int[] nums) {
        //如果不是完全升序，那么最后一个数肯定小于第一个数，这时候就进行二分查找
        //否则就是完全升序，返回第一个数
        int len = nums.length;
        if(nums[len - 1] > nums[0]){
            return nums[0];
        }
        int left = 0;
        int right = len - 1;
        int tmp = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] <= nums[len - 1]){
                //从mid到right这一段在升序，说明升序的起点还在左边
                right = mid - 1;
                tmp = mid;
            }else{
                //中间的某个点才是升序的起点
                left = mid + 1;
            }
        }
        return nums[tmp];
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine(); // 读取整行
        String[] parts = line.split(" "); // 按空格分割
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(findMin(nums));
        sc.close();
    }
}
