package hottop.top40;

/**
 * @ fileName:No62
 * @ description:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * @ author:zyk
 * @ createTime:2021/12/16 16:43
 * @ version:1.0.0
 */
public class No62 {
    //动态规划
    public int uniquePaths(int m,int n){
        int [][]f= new int[m][n];
        for (int i=0;i<m;i++){
            f[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i]=1;
        }
        for (int i=1;i<m;i++){
            for (int j = 1; j <n ; j++) {
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

    //方法2，排列组合C(m+n-2)(m-1)
}
