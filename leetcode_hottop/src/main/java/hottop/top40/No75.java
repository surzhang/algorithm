package hottop.top40;

/**
 * @ fileName:No75
 * @ description:荷兰旗问题
 * @ author:zyk
 * @ createTime:2021/12/16 16:44
 * @ version:1.0.0
 */
public class No75 {
    //单指针
    public void sortColors(int[] nums) {
        int n = nums.length;
        int pre = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[pre];
                nums[pre] = temp;
                ++pre;
            }
        }
        for (int i = pre; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[pre];
                nums[pre] = temp;
                ++pre;
            }
        }
    }

    //双指针
    public void sortColor2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}
