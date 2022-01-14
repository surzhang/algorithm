package hottop.top80;

/**
 * @FileName: No240
 * @Description: 搜索二维矩阵
 * @Author: zyk
 * @createTime: 2021/12/26 16:05
 * @version: 1.0
 */
public class No240 {
    //方法1：双重循环，方法二：二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        //row行
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //Z字型查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        //m行n列
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}
