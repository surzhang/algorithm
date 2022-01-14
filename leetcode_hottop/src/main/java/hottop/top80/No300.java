package hottop.top80;

/**
 * @FileName: No300
 * @Description: 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class No300 {
    //动态规划
    public int lengthOfLIS(int []nums){
        if (nums.length==0){
            return  0 ;
        }
        int []dp = new int[nums.length];
        dp[0]=1;
        //结果
        int maxans = 1;
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                //之前节点与当前节点相比较，如果当前节点更大，加1
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }

    //贪心算法+二分查找
    public int lengthOfLIS2(int[] nums) {
        int len = 1,n=nums.length;
        if (n==0){
            return 0;
        }
        int []d = new int[n+1];
        d[len]=nums[0];
        for (int i = 1; i <n ; i++) {
            if (nums[i]>d[len]){
                d[++len]=nums[i];
            }else{
                int l=1,r =len,pos=0;
                while (l<=r){
                    int mid= (l+r)>>1;
                    if (d[mid]<nums[i]){
                        pos  =mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }
}
