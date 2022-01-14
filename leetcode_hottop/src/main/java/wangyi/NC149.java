package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC149
 * @description :TODO KMP算法
 * @date 2022/1/11 14:35
 */
public class NC149 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算模板串S在文本串T中出现了多少次
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public int kmp (String S, String T) {
        // write code here
        if (S == null || S.length() == 0 || T == null || T.length() == 0){
            return 0;
        }
        int[] nexts = helper(S);
        int sIdx = 0;
        int tIdx = 0;
        int m = S.length();
        int n = T.length();
        int count = 0;

        while(tIdx < n){
            if (tIdx == -1 || S.charAt(sIdx) == T.charAt(tIdx)){
                tIdx ++;
                sIdx ++;
            }else{
                sIdx = nexts[sIdx];
            }
            if (sIdx == m){
                count += 1;
                sIdx = nexts[sIdx];
            }
        }

        return count;
    }

    private int[] helper(String S){
        char[] chs = S.toCharArray();
        int n = chs.length;
        int[] nexts = new int[n + 1];
        nexts[0] = -1;
        nexts[1] = 0;
        int i = 2;
        int j = 0;

        while(i <= n){
            if (j == -1 || chs[i - 1] == chs[j]){
                j++;
                nexts[i] = j;
                i++;
            }else{
                j = nexts[j];
            }
        }
        return nexts;
    }
}
