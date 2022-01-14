package hottop.top100;

/**
 * @FileName: No416
 * @Description: 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Author: zyk
 * @createTime: 2021/12/23 17:45
 * @version: 1.0
 */
public class No416 {
    public boolean canPartition(int []nums){
        //动态规划，二维数组
        int n = nums.length;
        if (n<2){
            return false;
        }
        int sum=0,maxNum = 0;
        for (int num:nums){
            sum+=num;
            maxNum=Math.max(maxNum,num);
        }
        if (sum%2!=0){
            return false;
        }
        int target = sum/2;
        if (maxNum>target){
            return false;
        }
        //dp方程
        boolean  [][]dp = new boolean[n][target+1];
        for (int i = 0; i <n ; i++) {
            dp[i][0]=true;
        }
        //当i==0时，只有一个正整数nums[0]可以取
        dp[0][nums[0]]=true;
        for (int i = 1; i <n ; i++) {
            int num = nums[i];
            for (int j = 1; j <=target ; j++) {
                if (j>=num){
                    dp[i][j]=dp[i-1][j]|dp[i-1][j-num];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }

}
