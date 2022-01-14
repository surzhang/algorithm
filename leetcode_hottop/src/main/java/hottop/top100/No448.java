package hottop.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No448
 * @Description: 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @Author: zyk
 * @createTime: 2021/12/23 17:44
 * @version: 1.0
 */
public class No448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int []nums = new int []{1,3,4,5,2,5,7};
        System.out.println(No448.findDisappearedNumbers(nums));
    }
}
