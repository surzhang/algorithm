package com.yun.number;

/**
 * @author zyk
 * @version 1.0
 * @fileName No172
 * @description :TODO 计算阶乘之后的0得个数
 * @date 2022/1/21 16:01
 */
public class No172 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
