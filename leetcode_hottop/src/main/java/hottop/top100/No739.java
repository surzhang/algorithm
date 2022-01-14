package hottop.top100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No739
 * @Description: 每日温度
 * @Author: zyk
 * @createTime: 2021/12/21 22:24
 * @version: 1.0
 */
public class No739 {
    public int[] dailyTemperature(int []temperatures){
        int length = temperatures.length;
        int[] ans = new int[length];
        //记录每个温度第一次出现的下标
        int[] next = new int[101];
        Arrays.fill(next,Integer.MAX_VALUE);
        for (int i = length-1; i >=0 ; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;

    }

//单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            //每日温度
            int temperature = temperatures[i];
            //当前温度大于栈顶元素
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                //结果下标
                int prevIndex = stack.pop();
                //存入结果
                ans[prevIndex] = i - prevIndex;
            }
            //存入温度的索引
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []a =new int []{73,74,75,71,69,72,76,73};
        hot_top.c100.No739 no739=new hot_top.c100.No739();
        int[] ints = no739.dailyTemperature(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(" "+ints[i]);
        }
    }
}
