package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC49
 * @description :TODO 最长的括号子串
 * @date 2022/1/11 14:37
 */
public class NC49 {
    public int longestValidParentheses (String s) {
        //最长的括号子串，使用栈，左括号入栈，遇到右半括号出栈并长度加2，没有左半括号就截止
        //注意，如果入栈数目多于右半括号，那么就不是连续的，必须右半括号完全与左半括号匹配才能计数
        if(s.isEmpty() || s.length()==0)
            return 0;
        int[] dp = new int[s.length()];        //动态规划数组
        int len = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '(')
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                else if(i - dp[i-1] > 0  &&  s.charAt(i-dp[i-1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] > 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            len = len < dp[i] ? dp[i] : len;
        }
        return len;
    }
}
