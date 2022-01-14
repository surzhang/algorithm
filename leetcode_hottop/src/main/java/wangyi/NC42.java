package wangyi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC42
 * @description :TODO 有重复项数字的所有排列
 * @date 2022/1/11 14:37
 */
public class NC42 {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        int n = num.length;
        if(n == 0 || num == null) return res;
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num,list,new boolean[num.length]);
        return res;
    }
    public void dfs(int[] num,ArrayList<Integer> list,boolean[] f) {
        if(list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if(f[i]) continue;
            if(i > 0 && num[i] == num[i - 1] && !f[i - 1]) continue;
            f[i] = true;
            list.add(num[i]);
            dfs(num,list,f);
            list.remove(list.size() - 1);
            f[i] = false;
        }
    }
}
