package hottop.top20;

import java.util.HashMap;
import java.util.Map;

/**
 * @ fileName:No1
 * @ description:两数之和
 * @ author:zyk
 * @ createTime:2021/12/1 23:19
 * @ version:1.0.0
 */
public class No1 {
    //方法1：双重循环

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    //方法2：map集合

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i <nums.length ; i++) {
            //如果存在对应的key,则其key是需要返回的值，i正好是其对应的位置
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            //map中存放数值和顺序，使用key更加方便
            map.put(nums[i],i);
        }
        return new int[0];
    }


}
