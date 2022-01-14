package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC32
 * @description :TODO 求平方根
 * @date 2022/1/11 14:33
 */
public class NC32 {
    public int sqrt (int x) {
        // write code here
        if (x <= 0)
            return x;
        long left = 1;
        long right = x;
        while(left < right) {
            long middle = (left + right) / 2;
            if (middle * middle <= x && (middle + 1) * (middle + 1) > x) {
                return (int)middle;
            } else if (middle * middle < x) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return (int) left;
    }
}
