package hottop.top40;

/**
 * @ fileName:No70
 * @ description:爬楼梯问题
 *
 * @ author:zyk
 * @ createTime:2021/12/16 16:44
 * @ version:1.0.0
 */
public class No70 {
    //动态规划
    public  int climbStairs(int n){
        if (n==1){
            return 1;
        }
        int[]dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
