package hottop.top60;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No102
 * @Description: 二叉树的层序遍历
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class No102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        //结果集
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        //队列
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer>level = new ArrayList<>();
            //当前层的节点
            int curLevelSize = queue.size();
            for (int i = 0; i <curLevelSize ; i++) {
                //检索，并不删除
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
