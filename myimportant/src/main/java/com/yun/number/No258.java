package com.yun.number;

/**
 * @author zyk
 * @version 1.0
 * @fileName No258
 * @description :TODO 各位相加
 * @date 2022/1/21 16:01
 */
public class No258 {
    public int addDigit(int num) {
        return (num - 1) % 9 + 1;
    }
}
