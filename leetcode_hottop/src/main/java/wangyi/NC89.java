package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC89
 * @description :TODO 字符串变形
 * @date 2022/1/11 14:36
 */
public class NC89 {
    public String trans(String s, int n) {
        // write code here
        if(s==null || n<=0){return s;}
        char[] sArr=s.toCharArray();
        //双指针 将字符串作为一个整体反转
        reverse(0,n-1,sArr);
        //各个单词作为一个整体 再反转一次
        int index=0;
        while(index<n){
            int end=index;
            while(end<n && sArr[end]!=' '){
                sArr[end]=upLower(sArr[end]);//大小写
                end++;
            }
            //找到空格了 单词的右边界为空格减一的位置
            reverse(index,end-1,sArr);
            index=end+1;//更新index 指向单词的首字母
        }
        return String.valueOf(sArr);
    }
    public void reverse(int l,int r,char[] sArr){
        int left=l,right=r;
        while(left<right){
            char tmp=sArr[left];
            sArr[left]=sArr[right];
            sArr[right]=tmp;
            left++;
            right--;
        }
    }
    public char upLower(char c){
        if(c>='a' && c<='z'){
            return (char)(c-32);//小写转大写
        }else if(c>='A' && c<='Z'){
            return (char)(c+32);//大写转小写
        }else{
            return c;//空格
        }
    }
}
