package hottop.top100;

import java.util.HashMap;

/**
 * @FileName: No560
 * @Description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * @Author: zyk
 * @createTime: 2021/12/22 11:05
 * @version: 1.0
 */
public class No560 {
    //暴力方法
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            int sum = 0;
            for (int j = i; j >=0 ; j--) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    //前缀和+hash表优化
    public int subarraySum2(int []nums,int k){
        int count=0,pre=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i <nums.length ; i++) {
            pre+=nums[i];
            if (map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
