package com.yun.twopoint;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zyk
 * @version 1.0
 * @fileName No56
 * @description :TODO 合并区间
 * @date 2022/1/21 14:50
 */
public class No56 {
    public int[][] merge(int [][]intervals){
        //长度为0直接返回
        if (intervals.length==0){
            return new int[0][2];
        }
        //数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //结果数组
        List<int[]>merged  =new ArrayList<>();
        for (int i = 0; i <intervals.length ; i++) {
            //左右边界
            int l  =intervals[i][0],r = intervals[i][1];
            if (merged.size()==0||merged.get(merged.size()-1)[1]<l){
                merged.add(new int[]{l,r});
            }
            //更新右边界
            merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],r);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
