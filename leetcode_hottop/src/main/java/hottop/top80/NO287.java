package hottop.top80;

/**
 * @FileName: NO287
 * @Description: 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * @Author: zyk
 * @createTime: 2021/12/26 16:03
 * @version: 1.0
 */
public class NO287 {
    //二分查找
    public int findDuplicate(int []nums){
        int n = nums.length;
        int l= 1,r=n-1,ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int cnt  =0;
            for (int i = 0; i <n ; i++) {
                if (nums[i]<=mid){
                    cnt++;
                }
            }
            if (cnt<=mid){
                l=mid+1;
            }else{
                r=mid-1;
                ans=mid;
            }
        }
        return ans;
    }

    //快慢指针
    public int findDuplicate2(int []nums){
        int slow = 0,fast = 0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
