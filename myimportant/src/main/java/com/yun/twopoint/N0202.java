package com.yun.twopoint;

/**
 * @author zyk
 * @version 1.0
 * @fileName N0202
 * @description :TODO 快乐数
 * @date 2022/1/21 14:31
 */
public class N0202 {
    //快慢指针法
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;

        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
