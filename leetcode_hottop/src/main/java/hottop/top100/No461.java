package hottop.top100;

/**
 * @FileName: No461
 * @Description: 汉明距离
 * @Author: zyk
 * @createTime: 2021/12/22 11:05
 * @version: 1.0
 */
public class No461 {
    public int hanmingDistance(int x,int y){
        return Integer.bitCount(x^y);
    }
    public int hanmingDistance2(int x,int y){
        int s = x^ y,ret = 0;
        while(s!=0){
            ret+=s&1;
            s>>=1 ;
        }
        return ret;
    }
}
