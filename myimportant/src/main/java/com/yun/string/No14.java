package com.yun.string;

/**
 * @author zyk
 * @version 1.0
 * @fileName No14
 * @description :TODO 查找最长公共前缀
 * @date 2022/1/21 15:11
 */
public class No14 {
    //把第一个作为公共前缀，然后依次比较
    public String longestCommonPrefix(String[]strs){
        if (strs.length==0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i <strs.length ; i++) {
            int j = 0;
            for (; j <ans.length()&&j<strs[i].length() ; j++) {
                if (ans.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if (ans.equals("")){
                return ans;
            }
        }
        return ans;
    }
}
