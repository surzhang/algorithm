package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC141
 * @description :TODO
 * @date 2022/1/11 14:34
 */
public class NC141 {
    public boolean judge (String str) {
        if (str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            return str.charAt(i) == str.charAt(str.length() - i - 1);
        }
        return false;
    }
}
