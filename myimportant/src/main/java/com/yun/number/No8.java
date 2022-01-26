package com.yun.number;

/**
 * @author zyk
 * @version 1.0
 * @fileName No8
 * @description :TODO  字符串转换整数
 * @date 2022/1/21 16:00
 */
public class No8 {
    public int myAtoi(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        //去掉前导空格
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        //如果已经遍历完成
        if (index==len){
            return 0;
        }
        int sign = 1;
        char firstChar = chars[index];
        if (firstChar=='+'){
            index++;
        }else if (firstChar=='-'){
            index++;
            sign=-1;
        }
        //将后续数字进行转换
        int res = 0;
        while(index<len){
            char curr = chars[index];
            //判断是否合法
            if(curr>'9'||curr<'0'){
                break;
            }
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (curr - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (curr - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res*10+sign*(curr-'0');
            index++;
        }
        return res;
    }
}
