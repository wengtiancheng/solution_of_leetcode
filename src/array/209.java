
class leetcode209 {
    //不是确定哪一项必须包含在子数组里面，而是确定子数组以哪一项开始，相较于之前自己的讨论更加明确
     public int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int[] res = new int[len];
        int count = len;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
        if(sum < target){
            return 0;
        }else{
           for(int i = 0; i < len; i++){
               int sum1 = nums[i];
               int count1 = 1;
               for(int j = i + 1; j < len; j++){
                   if(sum1 >= target){
                       res[i] = count1;
                       break;
                   }else{
                       sum1 += nums[j];
                       count1++;
                   }
               }
           }

        }



    }
    public int findForEach(int target, int pos, int[] nums){
        int len = nums.length;


        int left = pos - 1;
        int right = pos + 1;
        int sum = nums[pos];
        int count = 1;
        while(sum < target && left >= 0 && right < len){
            if(nums[left] < nums[right]){
                sum += nums[right];
                right++;
            }else{
                sum += nums[left];
                left--;
            }
            count++;
        }
        if(sum >= target){
            return count;
        }else if(left >= 0){
            while (sum < target && left >= 0){
                sum += nums[left];
                left--;
                count++;
            }
            if(sum < target){
                return 0;
            }else {
                return count;
            }
        }else if(right < len){
            while(sum < target && right < len){
                sum += nums[right];
                right++;
                count++;
            }
            if(sum < target){
                return 0;
            }else {
                return count;
            }
        }
        return 0;

    }

    //之前误解了子数组的定义，但是顺便复习了一下Mergesort，21个样例倒是也可以过18个
    //第二次只考虑了必须要选最大的数的情况，还是卡在了相同的用例上，好在方法可以复用
    public static void main(String[] args) {
        leetcode209 solution = new leetcode209();

        // 测试用例
        int target = 213;
        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};

        // 执行方法
        int result = solution.minSubArrayLen1(target, nums);

        // 输出结果
        System.out.println("Result: " + result);

        // 预期结果
        int expected = 8;  // 根据数组的前8个元素 [12, 28, 83, 4, 25, 26, 25, 2]，和是205，最后再加一个25，总和达到230，最小长度为8

        // 验证
        if (result == expected) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed! Expected: " + expected + ", but got: " + result);
        }
    }

}