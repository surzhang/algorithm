package hottop.top40;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @FileName: No84
 * @Description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @Author: zyk
 * @createTime: 2021/12/19 10:26
 * @version: 1.0
 */
public class No84 {
    //方法1：单调栈

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            //当下一个元素高度低于栈中元素高度，移除栈顶元素
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                //记录下右侧柱子编号
                right[stack.peek()] = i;
                stack.pop();
            }
            //下个元素的值大于栈中元素值，入栈（升序）,记录下左侧柱子编号
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            //往栈中添加元素的索引值
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i <n ; i++) {
            ans = Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
}
