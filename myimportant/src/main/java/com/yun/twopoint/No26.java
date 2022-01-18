package com.yun.twopoint;

/**
 * @author zyk
 * @version 1.0
 * @fileName No26
 * @description :TODO 删除有序数组中的重复项
 * @date 2022/1/18 11:54
 */
public class No26 {
    //双指针
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
