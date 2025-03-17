package hot100.lc74;

import java.util.Scanner;

public class lc74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0;
        int down = row - 1;
        int tmp = 0;
        while(up <= down){
            int mid = (up + down) / 2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                tmp = mid;
                up = mid + 1;
            }else{
                down = mid - 1;
            }
        }
        int left = 0;
        int right = col - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int res = matrix[tmp][mid];
            if(res == target){
                return true;
            }else if(res > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int m = 0;
        int n = 0;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }
}
