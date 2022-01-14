package hottop.top20;

import java.util.*;

/**
 * @ fileName:No17PhoneNum
 * @ description:给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * @ author:zyk
 * @ createTime:2021/12/10 23:28
 * @ version:1.0.0
 */
public class No17PhoneNum {
    public List<String> letterCombinations(String digits){
        //result
        List<String> combinations = new ArrayList<String>();
        if (digits.length()==0){
            return combinations;
        }
        Map<Character,String>phoneMap=new HashMap<Character, String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        //回溯(条件，层数，临时结果与总结果）
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
        
    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        //combinations总结果集，combination临时结果集，phoneMap手机号映射，digits输入的条件，index层数
        if (index==digits.length()){
            combinations.add(combination.toString());
        }else{
            //获取手机号数
            char digit = digits.charAt(index);
            //数字对应的字符串
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i <letterCount ; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                //删除掉数字层
                combination.deleteCharAt(index);
            }
        }
    }



    public List<String>letterCombinations1(String digits){
        LinkedList<String>ans = new LinkedList<String>();
        if (digits.isEmpty()){
            return ans;
        }
        String[]mapping = new String[]{
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()-'0')];
            for (char c:map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }
}


