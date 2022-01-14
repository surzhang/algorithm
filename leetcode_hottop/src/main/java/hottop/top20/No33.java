package hottop.top20;

/**
 * @ fileName:No33
 * @ description:旋转查找
 * @ author:zyk
 * @ createTime:2021/12/15 16:03
 * @ version:1.0.0
 */
public class No33 {
    public int search(int []nums,int target){
        int n = nums.length;
        //边界条件1
        if (n==0){
            return -1;
        }
        //边界条件2
        if (n==1){
            return nums[0]==target?0:-1;
        }
        //使用二分查找
        int left=0,right=n-1;
        while(left<=right){
            //这样写不容易越界
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[0]<=nums[mid]){
                if (nums[0]<=target&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if (nums[mid]<target && target <=nums[n-1]){
                    left = mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
