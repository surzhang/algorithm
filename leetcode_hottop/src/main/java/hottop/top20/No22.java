package hottop.top20;

import java.util.ArrayList;
import java.util.List;

/**
 * @ fileName:No22
 * @ description:括号生成（important）
 * @ author:zyk
 * @ createTime:2021/12/13 21:09
 * @ version:1.0.0
 */
public class No22 {
//   回溯
    public List<String> generateParenthesis(int n){
        List<String>list=new ArrayList<String>();
        backtrack(list,"",0,0,n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length()==max*2){
            list.add(str);
            return;
        }
        if (open<max){
            backtrack(list,str+"(",open+1,close,max);
        }
        if (close<open){
            backtrack(list,str+")",open,close+1,max);
        }
    }
}
