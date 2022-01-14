package hottop.top20;

/**
 * @ fileName:No10
 * @ description:字符串匹配问题,记住算了，有点难
 * @ author:zyk
 * @ createTime:2021/12/5 20:57
 * @ version:1.0.0
 */
public class No10 {

    /**
     * @ author: zyk
     * @ description:使用动态规划
     * @ date: 2021/12/10 20:53
     * @ param: [s, p]
     * @ return: boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matchs(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j - 1];
                    }
                } else {
                    if (matchs(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matchs(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
//时间复杂度O(mn),空间复杂度也是O(mn)
