package com.yun.number;

/**
 * @author zyk
 * @version 1.0
 * @fileName No7
 * @description :TODO
 * @date 2022/1/21 16:00
 */
public class No7 {
    public int reverse(int x){
        int rev = 0;
        while(x!=0){
            if (rev<Integer.MIN_VALUE/10||rev>Integer.MAX_VALUE/10){
                return 0;
            }
            int d = x%10;
            x /=10;
            rev = rev*10+d;
        }
        return rev;
    }
}
