package hottop.top20;

import java.util.HashSet;
import java.util.Set;

/**
 * @ fileName:No3
 * @ description:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @ author:zyk
 * @ createTime:2021/12/4 22:05
 * @ version:1.0.0
 */
public class No3 {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //哈希表，记录每个字符是否出现过
        Set<Character> occur = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //左指针右移一格，移除一个字符
                occur.remove(s.charAt(i - 1));
            }
            //获取最长子串
            while (rk + 1 < n && !occur.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occur.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
