package hottop.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName: No438
 * @Description: 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * @Author: zyk
 * @createTime: 2021/12/23 17:44
 * @version: 1.0
 */
public class No438 {
    //方法1：滑动窗口
    public static List<Integer>findAnagrams(String s,String p){
        int sLen = s.length();
        int pLen=p.length();
        //如果长度不满足直接返回
        if (sLen<pLen){
            return new ArrayList<Integer>();
        }
        //结果数组
        List<Integer>ans  = new ArrayList<>();
        int []sCount =new int[26];
        int []pCount = new int [26];
        for (int i = 0; i <pLen ; ++i) {
            ++sCount[s.charAt(i)-'a'];
            ++pCount[s.charAt(i)-'a'];
        }
        if (Arrays.equals(sCount, pCount)){
            ans.add(0);
        }
        //滑动窗口在这，在s字符串上右移
        for (int i = 0; i <sLen-pLen ; i++) {
            --sCount[s.charAt(i)-'a'];
            ++sCount[s.charAt(i+pLen)-'a'];
            if (Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hot_top.c90.No438.findAnagrams("hello","oll"));
    }
}

