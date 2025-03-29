/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int x, int y){
        int row = grid.length;
        int col = grid[0].length;
        if(x < 0 || x >= row || y < 0 || y >= col){
            return 0;
        }
        if(grid[x][y] == 0 || grid[x][y] == 2){
            return 0;
        }
        grid[x][y] = 2;
        return 1 + dfs(grid, x - 1, y) + dfs(grid, x + 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
// @lc code=end

