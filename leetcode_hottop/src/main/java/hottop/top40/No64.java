package hottop.top40;

/**
 * @ fileName:No64
 * @ description:给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 *
 * @ author:zyk
 * @ createTime:2021/12/16 16:43
 * @ version:1.0.0
 */
public class No64 {
    //动态规划（考虑边界条件）
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        //rows:行 cols:列
        int rows = grid.length,cols = grid[0].length;
        int [][]dp = new int[rows][cols];
        dp[0][0]=grid[0][0];
        for (int i=1;i<rows;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i <cols ; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i <rows ; i++) {
            for (int j = 1; j <cols ; j++) {
                dp[i][j]= Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
