package hottop.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @FileName: No621
 * @Description: 任务调度器，给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。
 * 其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * 在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * @Author: zyk
 * @createTime: 2021/12/22 11:04
 * @version: 1.0
 */
public class No621 {
    //构造
    public int leastInterval(char[]tasks,int n){
        Map<Character,Integer> freq = new HashMap<>();
        //最多的执行次数
        int maxExec = 0;
        for (char ch:tasks) {
            int exec  =freq.getOrDefault(ch,0)+1 ;
            freq.put(ch,exec);
            maxExec = Math.max(maxExec,exec);
        }
        //具有最多执行次数的任务数量
        int maxCount=0;
        Set<Map.Entry<Character,Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character,Integer>entry:entrySet) {
            int value=entry.getValue();
            if (value==maxExec){
                ++maxCount;
            }
        }
        return Math.max((maxExec-1)*(n+1)+maxCount,tasks.length);
    }
}
