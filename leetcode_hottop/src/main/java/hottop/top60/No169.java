package hottop.top60;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No169
 * @Description: 多数元素，给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * @Author: zyk
 * @createTime: 2021/12/20 9:31
 * @version: 1.0
 */
public class No169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    public int majorityElement1(int[] num){
        int major=num[0], count = 1;
        //只记录主要元素
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else {
                count--;
            }
        }
        return major;
    }

}
