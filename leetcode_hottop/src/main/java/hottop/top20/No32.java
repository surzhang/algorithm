package hottop.top20;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ fileName:No32
 * @ description:最长有效的括号
 * @ author:zyk
 * @ createTime:2021/12/15 16:03
 * @ version:1.0.0
 */
public class No32 {
    //用栈来解决
    public int longestValidParentheses(String s) {
        int maxlength = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxlength = Math.max(maxlength, i - stack.peek());
                }
            }
        }
        return maxlength;
    }

    //用动态规划来解决
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}

