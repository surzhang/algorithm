package hottop.top40;

import java.util.HashMap;

/**
 * @ fileName:No76
 * @ description:给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @ author:zyk
 * @ createTime:2021/12/16 17:42
 * @ version:1.0.0
 */
public class No76 {
        //滑动窗口
        public String minWindow(String s, String t) {
            if(s == null || s.length() < t.length() || s.length() == 0){
                return "";
            }
            HashMap<Character,Integer> map = new HashMap<Character,Integer>();
            for(char c : t.toCharArray()){
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                }
            }
            int left = 0;
            int minLeft = 0;
            int minLen = s.length()+1;
            int count = 0;
            for(int right = 0; right < s.length(); right++){
                if(map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right),map.get(s.charAt(right))-1);
                    if(map.get(s.charAt(right)) >= 0){
                        count ++;
                    }
                    while(count == t.length()){
                        if(right-left+1 < minLen){
                            minLeft = left;
                            minLen = right-left+1;
                        }
                        if(map.containsKey(s.charAt(left))){
                            map.put(s.charAt(left),map.get(s.charAt(left))+1);
                            if(map.get(s.charAt(left)) > 0){
                                count --;
                            }
                        }
                        left ++ ;
                    }
                }
            }
            if(minLen>s.length())
            {
                return "";
            }

            return s.substring(minLeft,minLeft+minLen);
        }
}
