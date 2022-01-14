package wangyi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC156
 * @description :TODO 数组中只出现一次的数
 * @date 2022/1/11 14:35
 */
public class NC156 {
    public static  int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3, 3, 3, 5, 5, 5,8};
        System.out.println(NC156.singleNumber(arr));
    }
}
