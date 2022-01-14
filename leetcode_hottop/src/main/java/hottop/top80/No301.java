package hottop.top80;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @FileName: No301
 * @Description: 删除无效的括号
 * @Author: zyk
 * @createTime: 2021/12/26 16:03
 * @version: 1.0
 */
public class No301 {
    //回溯+剪枝
    private List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s){
        int lremove = 0;
        int rremove = 0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)=='('){
                lremove++;
            }else if (s.charAt(i)==')'){
                if (lremove==0){
                    rremove++;
                }else{
                    lremove-- ;
                }
            }
        }
        helper(s,0,lremove,rremove);
        return res;
    }

    private void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

    class Solution {
        //广度优先搜索
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<String>();
            Set<String> currSet = new HashSet<String>();

            currSet.add(s);
            while (true) {
                for (String str : currSet) {
                    if (isValid(str)) {
                        ans.add(str);
                    }
                }
                if (ans.size() > 0) {
                    return ans;
                }
                Set<String> nextSet = new HashSet<String>();
                for (String str : currSet) {
                    for (int i = 0; i < str.length(); i ++) {
                        if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                            continue;
                        }
                        if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                            nextSet.add(str.substring(0, i) + str.substring(i + 1));
                        }
                    }
                }
                currSet = nextSet;
            }
        }

        private boolean isValid(String str) {
            char[] ss = str.toCharArray();
            int count = 0;

            for (char c : ss) {
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                    if (count < 0) {
                        return false;
                    }
                }
            }

            return count == 0;
        }
    }

}

