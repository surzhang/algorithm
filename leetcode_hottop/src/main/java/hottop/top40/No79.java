package hottop.top40;

/**
 * @FileName: No79
 * @Description: 单词搜索，给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Author: zyk
 * @createTime: 2021/12/19 9:41
 * @version: 1.0
 */
public class No79 {
    //回溯
    public boolean exist(char[][]board,String word){
        int h =board.length,w=board[0].length;
        boolean[][]visited = new boolean[h][w];
        for (int i = 0; i <h ; i++) {
            for (int j = 0; j <w ; j++) {
                boolean flag = check(board,visited,i,j,word,0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int cur) {
        //cur记录当前层数
        if (board[i][j]!=s.charAt(cur)){
            return false;
        }else if (cur==s.length()){
            return true;
        }
        visited[i][j]=true;
        //寻找的方向
        int [][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for (int []dir:directions){
            int newi = i+dir[0],newj=j+dir[1];
            //防止越界
            if (newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                //没有访问过
                if (!visited[newi][newj]){
                    boolean flag = check(board, visited, newi, newj, s, cur+1);
                    if (flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=false;
        return result;
    }

    public static void main(String[] args) {
        boolean [][]a = new boolean[2][2];
        System.out.println(a[0][0]);

    }
}
