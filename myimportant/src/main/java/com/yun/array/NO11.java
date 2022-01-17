package com.yun.array;

/**
 * @author zyk
 * @version 1.0
 * @fileName NO11
 * @description :TODO 盛最多水的容器
 * 1.枚举left bar x,right bar  y,(x-y)*height_diff O(n2)
 * 2.先选左右边界，然后慢慢向内收敛，双指针,左右夹逼
 * @date 2022/1/17 10:37
 */
public class NO11 {
    public int maxArea(int[] height) {
        //结果
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        //result
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i] : height[j];
            int area = (j - i) * minHeight;
            res = Math.max(res, area);
        }
        return res;
    }
}
