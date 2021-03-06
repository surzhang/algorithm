package wangyi;

import java.util.Arrays;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC95
 * @description :TODO 数组中的最长连续子序列
 * @date 2022/1/11 14:36
 */
public class NC95 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        Arrays.sort(nums);
        int res = 1, t = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                t += 1;
                res = Math.max(res, t);
            } else {
                t = 1;
            }
        }
        return res;
    }

}
