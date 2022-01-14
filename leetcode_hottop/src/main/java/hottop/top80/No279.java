package hottop.top80;


/**
 * @FileName: No279
 * @Description: 完全平方数
 * @Author: zyk
 * @createTime: 2021/12/26 16:04
 * @version: 1.0
 */
public class No279 {
    //动态规划,f[i] 表示最少需要多少个数的平方来表示整数 i。
    public int numSquares(int n) {
        //默认初始化值为0
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //最坏情况就是每次+1
            dp[i]=i;
            for (int j = 1; j * j <= i; j++) {
                //动态转移方程
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
