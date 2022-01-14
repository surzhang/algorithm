package wangyi;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC59
 * @description :TODO 矩阵的最小路径和
 * @date 2022/1/11 14:34
 */
public class NC59 {
    public int minPathSum (int[][] matrix) {
        // write code here
        int row = matrix.length;
        int line = matrix[0].length;
        int[][] distance = new int[row][line];
        distance[0][0] = matrix[0][0];
        for (int i = 1; i < line; i++) {
            distance[0][i] = distance[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            distance[i][0] = distance[i - 1][0] + matrix[i][0];
            for (int j = 1; j < line; j++) {
                distance[i][j] = matrix[i][j] + Math.min(distance[i - 1][j], distance[i][j - 1]);
            }
        }
        return distance[row - 1][line - 1];
    }
}
