import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class lc45 {
    public static int jump(int[] nums) {
        int step = 0;    //当前的跳跃步数
        int end = 0;     //这次跳跃的边界
        int farthest = 0; //目前能到达的最远位置
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == end){
                step++;
                end = farthest;
            }
        }
        return step;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组（空格分隔）");
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];

        for(int i= 0; i < input.length; i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        int result = jump(nums);
        System.out.println("最小跳跃次数是 " + result);
        
    }
}



