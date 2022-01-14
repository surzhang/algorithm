package wangyi;

import model.TreeNode;

/**
 * @author zyk
 * @version 1.0
 * @fileName NC98
 * @description :TODO 判断t1树中是否有与t2树完全相同的子树
 * @date 2022/1/11 14:35
 */
public class NC98 {
    /**
     *
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if(root1 == null) {
            return false;
        }
        if(isSame(root1, root2)) {
            return true;
        }
        return isContains(root1.left, root2) || isContains(root1.right, root2);
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val == root2.val) {
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }
        return false;
    }
}
