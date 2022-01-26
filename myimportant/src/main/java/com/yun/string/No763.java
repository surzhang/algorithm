package com.yun.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyk
 * @version 1.0
 * @fileName No763
 * @description :TODO 划分字母区间 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * @date 2022/1/21 15:32
 */
public class No763 {
//贪心算法
    public static List<Integer>partitionLabels(String s){
        int []last = new int [26];
        int length = s.length();
        for (int i = 0; i <length ; i++) {
            last[s.charAt(i)-'a']=i;
        }
        List<Integer> partition  =new ArrayList<>();
        int start  =0,end=0;
        for (int i = 0; i <length ; i++) {
            end = Math.max(end,last[s.charAt(i)-'a']);
            if (i == end){
                partition.add(end-start+1);
                start  =end+1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {

        No763.partitionLabels("abcabcdfgfdgjiln");
    }
}
