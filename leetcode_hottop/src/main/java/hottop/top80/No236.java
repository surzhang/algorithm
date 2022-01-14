package hottop.top80;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No236
 * @Description: 除自身以外数组的乘积
 * @Author: zyk
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * @createTime: 2021/12/26 16:06
 * @version: 1.0
 */
public class No236 {
    //暴力超时
    public static int[] productExceptSelf(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                temp *= nums[j];
            }
            res.add(temp);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = res.get(i);
        }
        return a;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        //L和R分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int [length];
        //L[i]为索引i左侧所有元素的乘积
        //对于索引为‘0’的元素，因为左侧没有元素，所以L[0]=1；
        L[0]=1;
        for (int i = 1; i <length ; i++) {
            L[i]=nums[i-1]*L[i-1];
        }
        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ints = hot_top.c70.No236.productExceptSelf(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
