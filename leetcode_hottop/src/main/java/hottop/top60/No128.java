package hottop.top60;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: No128
 * @Description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题
 * @Author: zyk
 * @createTime: 2021/12/19 11:26
 * @version: 1.0
 */
public class No128 {
    //使用hash表
    public int longestConsecutive(int []nums){
        Set<Integer>nums_set = new HashSet<>();
        for (int num:nums){
            nums_set.add(num);
        }
        int longestStreak = 0;
        for (int num:nums_set){
            //从最小位置开始，不是最小值跳过
            if (!nums_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                //从最小值正逐渐增加
                while(nums_set.contains(currentNum+1)){
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
