package hottop.top80;

/**
 * @FileName: No312 戳气球
 * @Description:
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1]
 * 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。
 * 如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

 * @Author: zyk
 * @createTime: 2021/12/26 16:03
 * @version: 1.0
 */
public class No312 {
    //动态规划
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [][]rec  =new int [n+2][n+2];
        int [] val  =new int [n+2];
        //头和尾都是1
        val[0] = val[n+1]=1;
        //数组赋值给val
        for (int i = 1; i <=n ; i++) {
            val[i] = nums[i-1];
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+2; j <=n+1 ; j++) {
                for (int k = i+1; k <j ; k++) {
                    int sum = val[i]*val[k]*val[j];
                    sum+=rec[i][k]+rec[k][j];
                    rec[i][j]=Math.max(rec[i][j],sum);
                }
            }
        }
        return rec[0][n+1];
    }
}
