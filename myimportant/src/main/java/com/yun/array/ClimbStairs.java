package com.yun.array;

/**
 * @author zyk
 * @version 1.0
 * @fileName ClimbStairs
 * @description :TODO 爬楼梯问题
 * 先把所有想法写出来，懵逼的时候
 * 暴力？基本情况列出来？找重复性
 * @date 2022/1/17 16:51
 */
public class ClimbStairs {
    public int climbStairs(int n){
        //先排除边界情况
        if(n==1){
            return 1;
        }
        //首先列出基本情况
        int []dp=new int [n];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i < n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
