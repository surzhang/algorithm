package hottop.top100;

import java.util.LinkedList;

/**
 * @FileName: No394
 * @Description: 字符串编码
 * @Author: zyk
 * @createTime: 2021/12/23 17:45
 * @version: 1.0
 */
public class No394 {
    //辅助栈
    public String decodeString(String s){
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer>stack_multi = new LinkedList<>();
        LinkedList<String>stack_res =new LinkedList<>();
        for (Character c:s.toCharArray()){
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi=0;
                res=new StringBuilder();
            }else if (c==']'){
                StringBuilder temp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i <cur_multi ; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast()+temp);

            }
            else if (c>='0'&&c<='9'){
                multi = multi * 10 + Integer.parseInt(c+"");

            }else{
                res.append(c);
            }

        }
        return res.toString();
    }
}
