package hottop.top40;

/**
 * @ fileName:No55
 * @ description:给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @ author:zyk
 * @ createTime:2021/12/16 16:43
 * @ version:1.0.0
 */
public class No55 {
    public boolean canJump(int []nums){
        if (nums==null){
            return false;
        }
        int end = nums.length-1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i]+i>=end){
                end=i;
            }
        }
        return end==0;
    }

    //贪心算法
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
