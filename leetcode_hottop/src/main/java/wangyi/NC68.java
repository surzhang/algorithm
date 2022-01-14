package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC68
 * @description :TODO 跳台阶
 * @date 2022/1/11 14:32
 */
public class NC68 {
    public int jumpFloor(int target){
        if (target<2){
            return 1;
        }
        int []a = new int[target+1];
        a[0]=1;
        a[1]=1;
        for (int i = 2; i <=target ; i++) {
            a[i]=a[i-1]+a[i-2];
        }
        return a[target];
    }
}
