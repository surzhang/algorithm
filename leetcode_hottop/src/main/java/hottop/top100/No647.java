package hottop.top100;

/**
 * @FileName: No647
 * @Description: 回文子串
 * @Author: zyk
 * @createTime: 2021/12/22 11:04
 * @version: 1.0
 */
public class No647 {
    //方法1：中心拓展法
    public int countSubString(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    //动态规划
    public int countSubstrings(String s) {
        int len1 = s.length();
        boolean[][] dp = new boolean[len1][len1];
        int res = 0;

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = i; j < len1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {    // aba 的情况
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {     // abcba的情况，i=0,j=4, j-i>1,所以检验里层是否也是回文串，即bab -> dp[i + 1][j - 1]
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }

}
