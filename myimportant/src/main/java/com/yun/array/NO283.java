package com.yun.array;

/**
 * @author zyk
 * @version 1.0
 * @fileName NO283
 * @description :TODO 移动0，先把所有解法写出来，然后再选择
 * @date 2022/1/17 10:22
 */
public class NO283 {
    /**
     *双指针
     * @param nums
     */
    public void moveZeroes(int []nums){
        //记录非0下标
        int j=0;
        //循环
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=0){
              nums[j]=nums[i];
              if (i!=j){
                  nums[i]=0;
              }
              j++;
            }
        }
    }


    public void moveZeroes01(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素！=0，就把其交换到左边，是0就交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }

    }

    public void moveZeroes02(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int []a={0,2,3,0,5};
        NO283 no283=new NO283();
        no283.moveZeroes(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
