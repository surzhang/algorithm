package hottop.top100;

/**
 * @FileName: No338
 * @Description: 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @Author: zyk
 * @createTime: 2021/12/23 17:45
 * @version: 1.0
 */
public class No338 {
//动态规划
    public int[]countBits(int n){
        int []bits = new int [n+1];
        int highBit  =0;
        for (int i = 1; i <=n ; i++) {
            if ((i&(i-1))==0){
                highBit=i;
            }
            bits[i]=bits[i-highBit]+1;

        }
        return bits;
    }

    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
