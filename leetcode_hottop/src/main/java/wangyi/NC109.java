package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC109
 * @description :TODO 岛屿数量
 * @date 2022/1/11 14:34
 */
public class NC109 {
    public void dfs(char[][] grid, int r, int c) {
        //行数
        int nr = grid.length;
        //列数
        int nc = grid[0].length;
//边界条件
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        //先判断退出条件
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
}