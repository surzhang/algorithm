package com.yun.twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName No3
 * @description :TODO 无重复字符的最长子串
 * @date 2022/1/18 11:53
 */
public class No3 {
    //题解：滑动窗口
    public int lengthOfLongSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                //如果包含，移动窗口
                start = Math.max(map.get(alpha), start);
            }
            // 不包含，放入map，更新长度
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
