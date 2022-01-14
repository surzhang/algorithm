package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC103
 * @description :TODO 反转字符串
 * @date 2022/1/11 14:33
 */
public class NC103 {
    public String solve (String str) {
        char[] ans = str.toCharArray();
        int len = str.length();
        for(int i = 0 ; i < len ;i++)
        {
            ans[i] = str.charAt(len-1-i);
        }
        return new String(ans);
    }
}
