package com.yun.twopoint;

import java.util.Stack;

/**
 * @author zyk
 * @version 1.0
 * @fileName No42
 * @description :TODO 接雨水
 * @date 2022/1/18 11:55
 */
public class No42 {
    //双指针
    public int trap(int []A){
        //双指针
        int a=0,b=A.length-1;
        //返回值
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(a<b){
            //左边界最大值
            leftMax=Math.max(leftMax,A[a]);
            //右边界最大值
            rightMax=Math.max(rightMax,A[b]);
            if (leftMax<rightMax){
                max+=(leftMax-A[a]);
                a++;
            }else{
                max+=(rightMax-A[b]);
                b--;
            }
        }
        return max;
    }

    //栈解法，单调栈
    public int trap1(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                //remove the top element
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                        0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
}
