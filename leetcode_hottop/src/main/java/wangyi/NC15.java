package wangyi;

import model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC15
 * @description :TODO 二叉树的层次遍历
 * @date 2022/1/11 14:32
 */
public class NC15 {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new ArrayDeque();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList();
            int n = queue.size();
            for (int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

}
