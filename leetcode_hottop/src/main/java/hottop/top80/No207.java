package hottop.top80;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No207
 * @Description: 课程表
 * @Author: zyk
 * @createTime: 2021/12/26 16:07
 * @version: 1.0
 */
public class No207 {
    List<List<Integer>>edges;
    int []visited;
    boolean valid = true;
    public boolean canFinish(int numCourses,int[][]prerequisities){
        //深度优先搜索
        edges = new ArrayList<>();
        //初始化
        for (int i = 0; i <numCourses ; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int [numCourses];
        for (int []info :prerequisities) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i <numCourses&&valid ; i++) {
            if (visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int u) {
        visited[u] =1;
        for (int v:edges.get(u)) {
            if (visited[v]==0){
                dfs(v);
                if (!valid){
                    return;
                }
            }else if (visited[v]==1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }


    //广度优先搜索
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre)) {
                if(--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

}
