package hottop.top60;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No104
 * @Description: 二叉树的深度
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class No104 {
    //深度搜索
    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }else{
            int leftHigh = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(leftHigh,right)+1;
        }
    }
    //广度优先搜索
    public int maxDepth1(TreeNode root){
        if (root==null){
            return  0 ;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int ans= 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode node =queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
