package hottop.top100;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No617
 * @Description: 合并二叉树
 * @Author: zyk
 * @createTime: 2021/12/22 11:04
 * @version: 1.0
 */
public class No617 {
    //DFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        TreeNode mergerd = new TreeNode(root1.val+root2.val);
        mergerd.left=mergeTrees(root1.left,root2.left);
        mergerd.right = mergeTrees(root1.right,root2.right);
        return mergerd;
    }

    //BFS
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        //队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }


}