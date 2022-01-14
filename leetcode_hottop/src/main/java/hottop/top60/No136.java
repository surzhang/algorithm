package hottop.top60;

/**
 * @FileName: No136
 * @Description: 只出现一次的数字
 * @Author: zyk
 * @createTime: 2021/12/19 11:26
 * @version: 1.0
 */
public class No136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
