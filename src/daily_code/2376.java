import java.util.Arrays;

class lc2376 {
    public int countSpecialNumbers(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        int[][] memo = new int[arr.length][1 << 10];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, false, arr, memo);



    }
    public int dfs(int i, int mask, boolean isLimit, boolean isNum, char[] arr, int [][] memo){
        if(i == arr.length){
            return isNum ? 1 : 0;
        }
        if(!isLimit && isNum && memo[i][mask] != -1){
            return memo[i][mask];
        }
        int res = 0;
        if(!isNum){
            res = dfs(i + 1, mask, false, false, arr, memo);
        }
        int up = isLimit ? arr[i] - '0' : 9;
        for(int d = isNum ? 0 : 1; d <= up; d++){
            if((mask >> d & 1) == 0){
                res += dfs(i + 1, mask | (1 << d) , isLimit && d == up, true, arr, memo);
            }
        }
        if(!isLimit && isNum){
            memo[i][mask] = res;
        }
        return res;

        

    }
}