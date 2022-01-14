package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC73
 * @description :TODO 数组中出现次数超过一半的数字
 * @date 2022/1/11 14:34
 */
public class NC73 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int voted = 1;
        int res = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i] == res){
                voted++;
            }else{
                voted--;
                if(voted == 0){
                    voted = 1;
                    res = array[i];
                }
            }
        }
        return res;
    }
}
