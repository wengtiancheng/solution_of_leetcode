/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    find(grid, i, j);
                    res++;
                }
            }
        }
        return res;
        
    }
    public void find(char[][] grid, int x, int y){
        int row = grid.length;
        int col = grid[0].length;
        if(x < 0 || x >= row || y < 0 || y >= col){
            return;
        }
        if(grid[x][y] == '0'){
            return;
        }else{
            grid[x][y] = '0';
            find(grid, x - 1, y);
            find(grid, x + 1, y);
            find(grid, x, y + 1);
            find(grid, x, y - 1);
        }
    }
}
// @lc code=end

