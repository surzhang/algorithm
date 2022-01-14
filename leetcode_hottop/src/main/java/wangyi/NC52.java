package wangyi;

import java.util.Stack;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC52
 * @description :TODO 有效的括号
 * @date 2022/1/11 14:33
 */
public class NC52 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){{}}}[[]";
        NC52.isValid(s);
    }
}
