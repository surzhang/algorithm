package hottop.top60;

/**
 * @FileName: No152
 * @Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * @Author: zyk
 * @createTime: 2021/12/20 9:31
 * @version: 1.0
 */
public class No152 {
    //动态规划，滚动数组

    public int maxProduct(int []nums){
        int maxF = nums[0],minF = nums[0],ans=nums[0];
        int len = nums.length;
        for (int i = 1; i <len ; i++) {
            int max = maxF,min=minF;
            //保存最大值(有负数的情况，所以判断三个）
            maxF = Math.max(nums[i]*max,Math.max(nums[i],nums[i]*min));
            //保存最小值
            minF = Math.min(nums[i]*min,Math.min(nums[i],nums[i]*max));
            ans = Math.max(ans,maxF);
        }
        return ans;
    }
}
