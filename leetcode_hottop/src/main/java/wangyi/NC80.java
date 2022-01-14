package wangyi;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC80
 * @description :TODO 把二叉树打印成多行
 * @date 2022/1/11 14:36
 */
public class NC80 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //层次遍历
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        while(q.size()>0 && q != null){
            int curSize = q.size();
            ArrayList<Integer> line = new ArrayList<>();
            for(int i = 0;i < curSize;i ++){
                TreeNode temp = q.poll();
                line.add(temp.val);
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            res.add(line);
        }
        return res;
    }
}
