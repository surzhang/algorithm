package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC71
 * @description :TODO 旋转数组的最小数字
 * @date 2022/1/11 14:35
 */
public class NC71 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int first = 0;
        int last = array.length-1;
        while(last>first){
            int mid = first+(last-first)/2;
            if(array[first]<array[last]){
                return array[first];
            }else if(array[mid]<array[last]){
                last = mid;
            }else if(array[mid]>array[last]){
                first = mid+1;
            }else{
                last--;
            }
        }
        return array[first];
    }
}
