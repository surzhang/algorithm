package hottop.top20;

/**
 * @ fileName:No31
 * @ description:实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列
 * （即，组合出下一个更大的整数）。
 * @ author:zyk
 * @ createTime:2021/12/15 16:02
 * @ version:1.0.0
 */
public class No31 {
    /**
     * @ author: zyk
     * @ description:倒序寻找非降序的a[i]，然后找非降序的a[j],然后调换位置，再逆序排列
     * @ date: 2021/12/15 16:21
     * @ param: [nums]
     * @ return: void
     */
    public void nextPermutation(int []nums){
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if (i>=0){
            int j= nums.length-1;
            while(j>=0&&nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left=start,right=nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
