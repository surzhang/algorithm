package com.yun.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName No387
 * @description :TODO 字符串中第一个唯一字符
 * @date 2022/1/18 10:54
 */
public class No387 {
    //使用hashmap存储他的频数
    public int firstUniqChar(String s) {
        Map<Character,Integer> hashmap=new HashMap<>();
        for (char c:s.toCharArray()) {
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <s.length() ; i++) {
            if (hashmap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
