package hottop.top40;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No101
 * @Description: 对称二叉树
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class No101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    //迭代
    public boolean check1(TreeNode u, TreeNode v) {
        //队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);

        }
        return true;
    }
}
