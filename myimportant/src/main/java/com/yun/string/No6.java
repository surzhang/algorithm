package com.yun.string;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @version 1.0
 * @fileName No6
 * @description :TODO Z字型变换
 * @date 2022/1/21 15:01
 */
public class No6 {
    public String convert(String s,int numRows){
        if (numRows<2){
            return s;
        }
        //行结果集合
        List<StringBuilder>rows  =new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            rows.add(new StringBuilder());
        }
        //i代表行，flag代表换行
        int i=0,flag = -1;
        for (char c: s.toCharArray()) {
            rows.get(i).append(c);
            if (i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        //结果集
        StringBuilder res  =new StringBuilder();
        for (StringBuilder row:rows) {
            res.append(row);
        }
        return res.toString();
    }
}
