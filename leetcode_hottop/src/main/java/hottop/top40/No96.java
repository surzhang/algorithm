package hottop.top40;

/**
 * @FileName: No96
 * @Description: 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class  No96 {
    //动态规划
    public int numTrees(int n){
        int []g = new int [n+1];
        g[0]=1;
        g[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                g[i]+=g[j-1]*g[i-j];
            }
        }
        return g[n];
    }

    public int numTrees2(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }


}
