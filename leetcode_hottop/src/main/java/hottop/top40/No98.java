package hottop.top40;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No98
 * @Description: 验证二叉搜索树
 * @Author: zyk
 * @createTime: 2021/12/19 11:25
 * @version: 1.0
 */
public class No98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST1(root.left, lower, root.val) && isValidBST1(root.right, root.val, upper);
    }


    //用栈来解决(中序遍历)

    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            //出栈的元素的值（下一个元素值应该大于他，否则返回false)
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
