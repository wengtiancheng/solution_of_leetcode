/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }
        int minute = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean spread = false;
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];

                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < row && newY >= 0 && newY < col){
                        if(grid[newX][newY] == 1){
                            grid[newX][newY] = 2;
                            queue.offer(new int[]{newX, newY});
                            freshCount--;
                            spread = true;
                        }
                    }
                }
            }
            if(spread){
                minute++;
            }
        }
        return freshCount == 0 ? minute : -1;
    }
    
}
// @lc code=end

