package hot100.lc41;

import java.util.Scanner;

public class lc41 {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            //注意这里循环的使用，有可能确实把当前的数字放在了正确的位置，但是被交换过来的数字也是一个正数，它不在正确的位置
            while(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp;
        tmp = sc.nextLine().split(" ");
        int len = tmp.length;
        int[] input = new int[len];
        for(int i = 0; i < len; i++){
            input[i] = Integer.parseInt(tmp[i]);
        }
        System.out.println("the fisrt missing postive number is " + firstMissingPositive(input));
    }
}
