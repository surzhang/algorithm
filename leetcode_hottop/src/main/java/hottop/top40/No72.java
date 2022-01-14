package hottop.top40;

/**
 * @ fileName:No72
 * @ description:给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * @ author:zyk
 * @ createTime:2021/12/16 16:44
 * @ version:1.0.0
 */
public class No72 {
    //方法1：动态规划
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }
        //dp数组
        int[][] dp = new int[n + 1][m + 1];
        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        //计算所有dp值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }
}
