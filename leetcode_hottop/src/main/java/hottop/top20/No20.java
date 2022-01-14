package hottop.top20;

import java.util.Stack;

/**
 * @ fileName:No20
 * @ description:有效的括号
 * @ author:zyk
 * @ createTime:2021/12/13 20:41
 * @ version:1.0.0
 */
public class No20 {
    //用栈来解决
    public boolean isValid(String s){
        Stack<Character>stack = new Stack<Character>();
        for (char c:s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if (c =='['){
                stack.push(']');
            }else if (stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }


}
