package hottop.top40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ fileName:No46
 * @ description:全部排列
 * @ author:zyk
 * @ createTime:2021/12/16 16:22
 * @ version:1.0.0
 */
public class No46 {
    //回溯法
    public List<List<Integer>>permutee(int[]nums){
        List<List<Integer>>res=new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num:nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first==n){
            res.add(new ArrayList<>(output));
        }
        for (int i=first;i<n;i++){
            //动态维护数组
            Collections.swap(output,first,i);
            //继续递归下一个数
            backtrack(n,output,res,first+1);
            //撤销操作
            Collections.swap(output,first,i);
        }
    }
}
