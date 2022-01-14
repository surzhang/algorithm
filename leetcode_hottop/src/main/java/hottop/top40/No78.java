package hottop.top40;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No78
 * @Description: 子集，给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @Author: zyk
 * @createTime: 2021/12/19 9:27
 * @version: 1.0
 */
public class No78 {
    public List<List<Integer>> subsets(int[] nums) {
        //结果集
       List< List<Integer>>  ans = new ArrayList<>();
       List<Integer> t = new ArrayList<>();
       dfs(0,nums,ans,t);
       return ans;
    }

    public  void dfs(int cur, int[] nums, List<List<Integer>> ans, List<Integer> t) {
        if (cur==nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        //考虑选择当前位置
        t.add(nums[cur]);
        dfs(cur+1,nums,ans,t);
//        考虑不选择当前位置
        t.remove(t.size()-1);
        dfs(cur+1,nums,ans,t);
    }

}
