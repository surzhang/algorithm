package hottop.top20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ fileName:No15ThreeSum
 * @ description:排序+双指针
 * @ author:zyk
 * @ createTime:2021/12/10 21:55
 * @ version:1.0.0
 */
public class No15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //先进行排序
        Arrays.sort(nums);
        //结果数组
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //枚举a
        for (int first = 0; first < n; first++) {
            //和上一次枚举数不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //c对应的指针初指向数组的最右侧
            int third = n - 1;
            int target = -nums[first];
            //枚举b
            for (int second = first + 1; second < n; second++) {
                //需要和上一次的枚举数不同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }

        }
        return ans;
    }
}
