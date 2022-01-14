package hottop.top40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ fileName:No56
 * @ description:以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * @ author:zyk
 * @ createTime:2021/12/16 16:43
 * @ version:1.0.0
 */
public class No56 {
    //排序
    public int [][]merge(int [][]intervals){
        if (intervals.length==0){
            return new int [0][2];
        }
        //数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //结果数组
        List<int[]>merged = new ArrayList<>();
        for (int i = 0; i <intervals.length ; i++) {
            //左右边界
            int L = intervals[i][0],R = intervals[i][1];
            //将第一个区间加入，或者本区间右边界小于下个区间左边界
            if (merged.size()==0||merged.get(merged.size()-1)[1]<L){
                merged.add(new int[]{L,R});
            }else{
                //更新右边界
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
