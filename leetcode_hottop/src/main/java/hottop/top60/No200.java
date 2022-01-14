package hottop.top60;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No200
 * @Description:
 * @Author: zyk
 * @createTime: 2021/12/20 9:32
 * @version: 1.0
 */
public class No200 {
    public int numIslands(char[][]grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        //行数
        int nr = grid.length;
        //列数
        int nc = grid[0].length;
        int num_island = 0;

        for (int i = 0; i <nr ; i++) {
            for (int j = 0; j <nc ; j++) {
                if (grid[i][j]=='1'){
                    ++num_island;
                    grid[i][j] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(i*nc+j);
                    while(!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id/nc;
                        int col = id%nc;
                        if (row -1 >=0&&grid[row-1][col] == '1'){
                            neighbors.add((row-1)*nc+col);
                            grid[row-1][col]='0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return num_island;
    }
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

    public int numIslands2(char[][] grid) {
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

