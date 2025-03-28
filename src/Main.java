import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> tmp = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            tmp.put(sum, tmp.getOrDefault(sum, 0) + 1);
            res += tmp.getOrDefault(k, 0);
        }
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            tmp.put(nums[i - 1], tmp.get(nums[i - 1]) - 1);
            res += tmp.getOrDefault(k + ans, 0);
            ans += nums[i];
        }
        return res;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()){
            String[] strs = sc.nextLine().split(" ");
            int[] nums = new int[strs.length];
            for(int i = 0; i < strs.length; i++){
                nums[i] = Integer.parseInt(strs[i]);
            }
            int k = sc.nextInt();
            System.out.println(Main.subarraySum(nums, k));

        }
    }
}