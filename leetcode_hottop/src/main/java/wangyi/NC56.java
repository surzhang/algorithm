package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC56
 * @description :TODO 回文数字
 * @date 2022/1/11 14:37
 */
public class NC56 {

    public boolean isPalindrome(int x) {
        int sign = x;
        if (x < 0) {
            return false;
        }
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return false;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        if (rev == sign) {
            return true;
        } else {
            return false;
        }
    }
}
